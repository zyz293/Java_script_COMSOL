%% COMSOL model builder using Java API

% Input: 
% binary image file, 
% dielectric 'master curve' for matrix,
% interphase shift factor

% Output: 
% COMSOL mph model file
% complex permittivity of composite
% -------------------------------------------

function []= main(TrialNo, binsource, const)
global vf_expt ...          % Labeled volume fraction
    ACMode  ...             % '1' for AC dielectric spectra, '0' for DC dielectric breakdown
    CheckOverlap ...        % '1' for removing overlapped interphase, '0' for keeping overlapped interphase (recommended)
    GBbr GBbs ...           % Gaussian lowpass filter parameters. 'br': size, 'bs': std deviation
    DomLength ...           % Simulation domain length
    ActualLength  ...       % Pixelated length of orignal TEM image
    dimension_to_pixel ...  % Ratio of physical dimension to pixel 
    ImageType ...           % 'grayscale', 'binary', or 'recon'
    CutSide ...             % Portion of the simulation window that will not be assigned with clusters. See load_image function for details
    TauShift1 DeltaEpsilonShift1 TauShift2 DeltaEpsilonShift2 ConstEpsilonShift ...
    InterfaceThickness1 InterfaceThickness2 InterfaceThickness... 
    epmodel ...  			% Updated Nov 9, 2014 HZ. PP polymer has constant value eps' and eps"
    isEpsDistribution ...   % '1' for prony series or any distribution for complex dielectric permittivity function (freq dependent)
	isReScale ... 			% Updated Nov 9. Do not re-scale ellipse axes according to labeled VF. Use actual VF from binary image
    ControlMode ... 
    isGetSolution ACbreakdown ManualMesh MeshLevel
% User inputs
vf_expt                 = 1/100;                             % In percentage, labeled volume fraction
DomLength               = 1000;                            % 'Recon' mode only: simulation pixelated domain length
ImageType               = 'binary';                        % 'grayscale' (direct usage not recommended. Convert to binary image first), 'binary', or 'recon'
ControlMode             = 'linux';                          % OS environment. 'remote' for linux. 'mac' for mac. 'local' for PC
dimension_to_pixel      = const.dimension_to_pixel;        % [nm]/[# of pixel]
CutSide                 = 0.1;                              % Assign all clusters in the central (1-cutside*2)^2 region.
IP1                     = 10;                               % [nm]
IP2                     = 50;                               % [nm]
InterfaceThickness1     = IP1*1e-6;                          % [mm], physical length, Interficial region thickness with constant properties
InterfaceThickness2     = IP2*1e-6;                          % [mm], physical length, Interficial region thickness with freq dependent properties

isReScale 				= 1;            % '1' for re-scaling to match with vf_expt. '0' to use actual VF from binary image
isGetSolution           = 1;            % '1' for getting solution. '0' for outputing a MPH model with just simulation setup w/o running simulation
isEpsDistribution 		= 1;            % '1' for using dielectric relaxation distribution, rather than a fixed value
ACMode                  = 1;            % '1' for permittivity study, '0' for breakdown
ACbreakdown             = 0;            % use 0
CheckOverlap            = 0;            % use 0
ManualMesh              = 0; 
MeshLevel               = 5;            % Use when ManualMesh = 0. Range from 1 to 9 (finest to most coarse)

% Config inputs
InterfaceThickness      = InterfaceThickness2 + InterfaceThickness1; 
if isEpsDistribution == 0; % Constant valued permittivity model (not frequency dependent)
	% polymer permittivity
	epmodel.ep		= 2; 
	epmodel.epp 	= 1e-3;
	% interphase permittivity added by shifting factors
	epintShift 	= 0;
	epmodel.epint 	= epmodel.ep + epintShift;
	eppintShift 	= 0;
	epmodel.eppint 	= epmodel.epp + eppintShift;
end

if ACMode == 1
    strACMode = 'AC';
else if ACMode == 0
        strACMode = 'DC';
    end
end

GBbr                    = 25;           % N/A for 'binary' and 'recon'
GBbs                    = 10;           % N/A for 'binary' and 'recon'

load(binsource);
image                   = img_out;
ActualLength            = length(image);                        % Characterized pixelated image length
PScoeff                = './RoomTempEpoxyYHNew.mat';             % Dynamfit result of polymer matrix Prony series coefficients% Modified epsilon_inf.
      
switch ImageType
    case 'binary'    
        disp('Take input from binary image.')
        imagefile               = image;
    case 'recon'     
        imagefile               = ['img_para_',binsource,'_Trial_',num2str(TrialNo),'.mat']; % Data file containing N by 5 matrix 'img_para'
        disp('Take input from reconstructed microstructure.')        
end

% Shifting factors for Prony series
TauShift1                            = const.TauShift1;  				% beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
DeltaEpsilonShift1                   = const.DeltaEpsilonShift1 ;       % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
TauShift2                            = const.TauShift2;                 % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
DeltaEpsilonShift2                   = const.DeltaEpsilonShift2;        % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
ConstEpsilonShift                    = const.ConstEpsilonShift;

tic
% Run Model
savefile = ['./HZ_2D_comsolbuild_',strACMode,'_',ImageType,'_',date,'_IP',num2str(IP1),'+',num2str(IP2),'_run_',num2str(TrialNo)]; % Output COMSOL project name
[model] = myfun_comsol_build(PScoeff, imagefile, savefile);

disp('Job done. Output result to .mph file');
% Export API-created model to file
mphsave(model, savefile);
toc
end
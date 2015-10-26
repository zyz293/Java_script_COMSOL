% 'myfun_comsol_build': build and compute solution from COMSOL 
% polymer dielectric nanocomposite model with Java API
% ----------------------------------------------------------------------
% CONTROLMODE:              string, 'local' for Windows PC, 'remote' for Linux 
% EXPTDATAFILE:             string, filename of data source of epoxy dielectric properties
% IMAGEFILE:                string, image file name
% SHAPE:                    string, 'ellipse' for elliptical fillers, 'circle' for circular fillers
% CREATESOLUTION:           integer, '1' create and compute solution, '0' create COMSOL model only
% ACBREAKDOWN:              integer, '1' create AC breakdown path

function [model] = myfun_comsol_build(PScoeff, imagefile,savefile)
% Initialization
global TauShift1 DeltaEpsilonShift1 TauShift2 DeltaEpsilonShift2 ConstEpsilonShift ACMode isEpsDistribution ...
    ControlMode isGetSolution
% Add COMSOL API command folders to MATLAB path
switch lower(ControlMode)
    case ('pc')
        addpath('C:\COMSOL42\mli','C:\COMSOL42\mli\startup');
        addpath('D:\COMSOL42\mli','D:\COMSOL42\mli\startup');
        addpath('E:\COMSOL42\mli','E:\COMSOL42\mli\startup');
    case ('linux')
        addpath('/home/hzg972/comsol42/mli','/home/hzg972/comsol42/mli/startup');
    case ('mac')
        addpath '/Applications/COMSOL42a/mli/startup'; % Mac
        addpath '/Applications/COMSOL42a/mli';
end

%% Section One: Load Data
myfun_comsol_load_constant();

% Step One: Load input dielectric function model, if needed
if isEpsDistribution
	myfun_comsol_load_epsilon_model(PScoeff);
end

% Step Two: Define composite structure
myfun_comsol_load_image(imagefile);

% Connect with COMSOL server with port number, default 2036.
mphstart(2036);
import com.comsol.model.*
import com.comsol.model.util.*
model = ModelUtil.create('Model');
model.modelNode.create('mod1');

%% Section Two: Create COMSOL model
% Step One: Initialize model
model       = myfun_comsol_create_model(model);

% Step Two: Create statistically re-generated microstructure
model       = myfun_comsol_create_structure(model);

% Step Four: Create boundary selection indices
indBoundary = myfun_comsol_create_boundary_selection(model);

% Step Five: Assign entities with material properties
model       = myfun_comsol_create_material(model);

% Step Six: Create physics
model       = myfun_comsol_create_physics(model, indBoundary);

% Step Seven: Create mesh
model       = myfun_comsol_create_mesh(model,  indBoundary);

if ACMode
    SF  	= [TauShift1, DeltaEpsilonShift1, TauShift2 ,DeltaEpsilonShift2,ConstEpsilonShift  ];
    model   = myfun_comsol_create_shifting_factors(model, SF);
end
%% Section Three:  Obtain solution from COMSOL
% Step One: Create Physics-based Study
model       = myfun_comsol_create_study(model);

if isGetSolution == 1
    % Step Two: Obtain solution
    model   = myfun_comsol_create_solution(model);
    
    % Step Three: Post-processing
    model   = myfun_comsol_post_process(model, indBoundary, savefile);
end

end
% Load constants
function [] = myfun_comsol_load_constant()

global rt_electrode1X rt_electrode2X rt_electrode3X rt_electrode1Y rt_electrode2Y rt_electrode3Y ... % electrode coordinates
    AppliedVoltage InitialVoltage MatrixConductivity InterfaceConductivity CurrentSource FillerConductivity ... % electric properties
    FillerRelPerm InterfaceRelPerm InterfaceImagPerm ElectrodeConductivity ElectrodeRelPerm ...
    FreqRange TimeRange ACMode extra_E_infi

switch (ACMode)
    case (1)
    otherwise % DC mode. rectangular box
        rt_electrode1X                 = 0.125/0.3;
        rt_electrode1Y                 = 0;
        rt_electrode2X                 = 0.15/0.3;
        rt_electrode2Y                 = 0.03/0.15;
        rt_electrode3X                 = 0.175/0.3;
        rt_electrode3Y                 = 0;
end

% Model parameters
extra_E_infi                        = -0.55;                % polymer matrix adjustment: vertical shift from prony series output and expt data comparison
AppliedVoltage                      = 1.5e-3;               % Initial voltage applied on electrode
InitialVoltage                      = 0.01e-3;              % Initial voltage applied over entire domain
CurrentSource                       = 2e3;                   % Current source from electrode
FreqRange                           = 10.^(-3:0.2:6);       % Frequency range of AC terminal
TimeRange                           = 'range(0,0.25,20)';    % Time range for DC study

% Material Properties
MatrixConductivity                  = 1e-15;                 % Electric conductivity of fillers, matrix and interface
FillerConductivity                  = MatrixConductivity;    % Conductivity of filler
FillerRelPerm                       = 3.9;                   % 3x of matrix's. Relative permittivity of filler
InterfaceRelPerm                    = 2.4;                   % Relative permittivity of IF1
InterfaceImagPerm                   = 0.001; 
InterfaceConductivity               = 1e-11;                 % Conductivity of IF1
ElectrodeRelPerm                    = 2; 
ElectrodeConductivity               = 1e6;                  % Conductivity of electrode

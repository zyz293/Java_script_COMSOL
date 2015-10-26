% Load dielectric function for interphase
function [] = myfun_comsol_load_epsilon_model(data)
global ACMode epmodel extra_E_infi
switch lower(ACMode)
    case (1) % AC mode
        disp('AC mode is selected. Begin applying dielectric permittivity spectroscopy Prony series to polymer data.');
        load(data);
        % Read in the MTD from the output of Dynamfit
        NumOfTerms = length(TemPR);
        for i = 1 : NumOfTerms - 1
            MTD_Coeff(2*i-1)=TemPR(i,2);
            MTD_Coeff(2*i)=log10(abs(TemPR(i,1)));
        end
        MTD_Coeff(2 * NumOfTerms - 1) = TemPR(NumOfTerms,2) + extra_E_infi; % Assign E_infi with last Epsilon
        % Convert MTD parameters to strings        
        [epmodel.ep, epmodel.epp, epmodel.epint, epmodel.eppint] = MTD_str(MTD_Coeff);
    otherwise
        disp('DC mode is selected. No need to compute complex dielectric permittivity.');
        epmodel = [];
end
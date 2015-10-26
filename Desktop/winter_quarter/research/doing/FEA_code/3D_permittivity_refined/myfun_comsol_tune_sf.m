function [] = myfun_comsol_tune_sf(mphfile, const)
mphstart(2036);
import com.comsol.model.*
import com.comsol.model.util.*
model = mphload([mphfile,'.mph']);

% Shifting factors for Prony series
TauShift1                            = const.TauShift1;  				% beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
DeltaEpsilonShift1                   = const.DeltaEpsilonShift1 ;       % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
TauShift2                            = const.TauShift2;                 % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
DeltaEpsilonShift2                   = const.DeltaEpsilonShift2;        % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
ConstEpsilonShift                    = const.ConstEpsilonShift;
SF  	= [TauShift1, DeltaEpsilonShift1, TauShift2 ,DeltaEpsilonShift2,ConstEpsilonShift  ];
% Update new shifting factors
model   = myfun_comsol_create_shifting_factors(model, SF);
disp('Assigned new shift factors in model.')
% Run solution and output new csv files with complex permittivity
model.sol('sol1').runAll;
model.result('pg1').run;
model.result('pg2').run;
model.result('pg3').run;
disp('Finished re-running model.')

model.result.numerical('av1').setResult;
txtfilenameImag = [mphfile,'_CompPermImag.csv'];
model.result.export('plot1').run;
disp('Wrote imaginary composite permittivity to file:'); disp(txtfilenameImag);

model.result.numerical('av2').setResult;
txtfilenameReal = [mphfile,'_CompPermReal.csv'];
model.result.export('plot2').run;
disp('Wrote real composite permittivity to file:'); disp(txtfilenameReal);

mphsave(model, mphfile);
end
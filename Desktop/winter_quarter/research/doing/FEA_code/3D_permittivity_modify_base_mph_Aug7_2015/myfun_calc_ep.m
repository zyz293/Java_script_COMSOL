function [intep, intepp] = myfun_calc_ep(datafile, sf, logfreq)
load(datafile)
TS1                   = sf(1);                    % beta relaxation, s_beta, Tau shift. For tau <= 1, Shift multiplier along x direction. 1 is no shift
DS1                   = sf(2);                      % beta relaxation, M_beta, DeltaEpsilonShiftFor tau <= 1, Shift multiplier along y direction. 1 is no shift
TS2                   = sf(3);                    % Alpha relaxation, s_alpha, For tau > 1, Shift multiplier along x direction. 1 is no shift
DS2                   = sf(4);                      % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
CES                   = sf(5);               % ConstEpsilonShift

[NumOfTerms,Temp] = size(TemPR); % Prony series coefficients
epsilon_inf = TemPR(NumOfTerms,2);

ep = zeros(length(logfreq),1);epp=zeros(length(logfreq),1);
intep = zeros(length(logfreq),1);intepp=zeros(length(logfreq),1);
for j = 1:length(logfreq)
    epsilonp =0; epsilonpp =0;
    intepsilonp = 0; intepsilonpp = 0;
    freq =10^logfreq(j);
    for i = 1 : NumOfTerms - 1
        deltaEpsilon =TemPR(i,2);
        tau =TemPR(i,1);
        epsilonp = epsilonp  + deltaEpsilon/(1+(freq*tau)^2);
        epsilonpp = epsilonpp + deltaEpsilon*freq*tau/(1+(freq*tau)^2);
        if tau>0.01
            intepsilonp = intepsilonp + DS2*deltaEpsilon/(1+(TS2*freq*tau)^2);
            intepsilonpp = intepsilonpp + DS2*deltaEpsilon*TS2*freq*tau/(1+(TS2*freq*tau)^2);
        else
            intepsilonp = intepsilonp + DS1*deltaEpsilon/(1+(TS1*freq*tau)^2);
            intepsilonpp = intepsilonpp + DS1*deltaEpsilon*TS1*freq*tau/(1+(TS1*freq*tau)^2);
        end
    end
    epsilonp = epsilonp + epsilon_inf;
    intepsilonp = intepsilonp + epsilon_inf+CES;
    ep(j) = epsilonp; epp(j) = epsilonpp;
    intep(j) = intepsilonp; intepp(j)=intepsilonpp;
end

end
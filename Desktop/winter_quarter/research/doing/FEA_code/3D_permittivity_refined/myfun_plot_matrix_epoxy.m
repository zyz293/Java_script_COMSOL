% Plot permittivity of polymer matrix and interphase (output from prony series) as a
% function of frequency

clear all
clc, close all
% ------------------input section------------------------
inc = 0.1;
logfreq = -4:inc:6;
freq = zeros(length(logfreq),1);
for i = 1:length(logfreq)
    freq(i) = 10^logfreq(i);
end
% -------------------------------------------------------
sf1 = [1,1,1,1,-0.55]; % Shift factors 
[ep1,epp1]=myfun_calc_ep('RoomTempEpoxyYHNew.mat',sf1, logfreq);

% Read experimental dielectric spectroscopy data from csv file
expt = csvread( './expt_epoxy_DS/neat_epoxy2-YH.csv');
freq2 = expt(:,1); ep2 = expt(:,2); epp2=expt(:,3);

% Plot prony series prediction and expt values
figure()
semilogx(freq,ep1), hold on
semilogx(freq2,ep2,'r')
xlabel 'log(Frequency [Hz])'
ylabel '\epsilon^'''
legend('fem', 'expt')

figure()
semilogx(freq,epp1),hold on
semilogx(freq2,epp2,'r')
xlabel 'log(Frequency [Hz])'
ylabel '\epsilon^"'
legend('fem', 'expt')
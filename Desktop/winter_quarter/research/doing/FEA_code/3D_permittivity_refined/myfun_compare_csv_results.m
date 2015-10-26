% Compare FEA with experimental results
clear all
clc, close all

% Output COMSOL project name
mphfile = 'HZ_2D_comsolbuild_AC_binary_06-Aug-2015_IP10+50_run_1'; 
% Experiment result filename
expt = csvread( './expt_epoxy_DS/neat_epoxy2-YH.csv');

%--------------------------------------------------------------
% Read experimental dielectric spectroscopy data from csv file
freq2 = expt(:,1); ep2 = expt(:,2); epp2=expt(:,3);

txtfilenameImag = [mphfile,'_CompPermImag.csv'];
txtfilenameReal = [mphfile,'_CompPermReal.csv'];

FEAPermReal = csvread(txtfilenameReal);
FEAPermImag = csvread(txtfilenameImag);
freq = FEAPermImag(:,1);
epp1 = FEAPermImag(:,2);
ep1 = FEAPermReal(:,2);

figure() % real
semilogx(freq,ep1), hold on
semilogx(freq2,ep2,'r')
xlabel 'log(Frequency [Hz])'
ylabel '\epsilon^'''
legend('fem', 'expt')

figure() % imag
semilogx(freq,epp1),hold on
semilogx(freq2,epp2,'r')
xlabel 'log(Frequency [Hz])'
ylabel '\epsilon^"'
legend('fem', 'expt')
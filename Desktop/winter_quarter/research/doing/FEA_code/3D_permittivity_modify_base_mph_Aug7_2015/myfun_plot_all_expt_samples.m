% Plot all experimental data of samples
clear all
clc, close all

neat = csvread( './expt_epoxy_DS/neat_epoxy2-YH.csv');
freq1 = neat(:,1); ep1 = neat(:,2); epp1 = neat(:,3);

bs1wt = csvread('./expt_epoxy_DS/BS_1wt%-TK.csv');
freq2 = bs1wt(:,1); ep2=bs1wt(:,2); epp2=bs1wt(:,3);

bs2wt = csvread('./expt_epoxy_DS/BS_2wt%-YH.csv');
freq3 = bs2wt(:,1); ep3=bs2wt(:,2); epp3=bs2wt(:,3);

bs7wt = csvread('./expt_epoxy_DS/BS_7wt%-YH.csv');
freq4 = bs7wt(:,1); ep4=bs7wt(:,2); epp4=bs7wt(:,3);

pgma1 = csvread('./expt_epoxy_DS/BS_PGMA_2wt%-TK.csv');
freq5 = pgma1(:,1); ep5=pgma1(:,2); epp5=pgma1(:,3);

ferro = csvread('./expt_epoxy_DS/ferrocene_PGMA_2wt-TK.csv');
freq6 = ferro(:,1); ep6=ferro(:,2); epp6=ferro(:,3);

monothio =csvread('./expt_epoxy_DS/monothiophene-PGMA_2wt%-YH.csv');
freq7 = monothio(:,1); ep7=monothio(:,2); epp7=monothio(:,3);

terthio =csvread('./expt_epoxy_DS/terthiophene_PGMA_2wt%-TK.csv');
freq8 = terthio(:,1); ep8=terthio(:,2); epp8=terthio(:,3);

anthra =csvread('./expt_epoxy_DS/anthracene_PGMA_2wt%-YH.csv');
freq9 = anthra(:,1); ep9=anthra(:,2); epp9=anthra(:,3);

figure()
semilogx(freq1,ep1), hold on
semilogx(freq2,ep2,'r')
semilogx(freq3,ep3,'k')
semilogx(freq4,ep4,'bv')
semilogx(freq5,ep5,'b<')
semilogx(freq6,ep6,'b>')
semilogx(freq7,ep7,'kv')
semilogx(freq8,ep8,'g')
semilogx(freq9,ep9,'y')

xlabel 'log(Frequency [Hz])'
ylabel '\epsilon^'''
legend('neat', 'BS1wt', 'BS2wt', 'BS7wt', 'PGMA', 'ferrocene', 'monothio','terthio','anthra')

figure()
semilogx(freq1,epp1),hold on
semilogx(freq2,epp2,'r')
semilogx(freq3,epp3,'k')
semilogx(freq4,epp4,'bv')
semilogx(freq5,epp5,'b<')
semilogx(freq6,epp6,'b>')
semilogx(freq7,epp7,'kv')
semilogx(freq8,epp8,'g')
semilogx(freq9,epp9,'y')
xlabel 'log(Frequency [Hz])'
ylabel '\epsilon^"'
legend('neat', 'BS1wt', 'BS2wt', 'BS7wt', 'PGMA', 'ferrocene', 'monothio','terthio','anthra')

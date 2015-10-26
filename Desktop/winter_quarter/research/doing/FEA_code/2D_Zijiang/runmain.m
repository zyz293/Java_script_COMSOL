% runmain.m
clear all; close all; clc; warning('off', 'all')

% Interphase shift factors for sample
run = 1;                       
const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
const.ConstEpsilonShift		= 0;
const.dimension_to_pixel	= 500/523; % [nm]/[# of pixel]
bin_img = './crop_BS_1wt%';
main(run, bin_img, const);
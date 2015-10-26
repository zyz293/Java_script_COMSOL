% runmain.m
clear all; close all; clc; warning('off', 'all')
           
const.L                     = 600; % voxel side length in 3D FEA
const.vf                    = 1/100;
const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
const.ConstEpsilonShift		= 0;
const.tau                   = 0.05; % tau*freq_crit = 1. E.g, for freq_crit = 10 Hz, tau = 0.1 s. 
const.dimension_to_pixel	= 400/240; % [nm]/[# of pixel]

bin_img = './sample_binary_input_3D_parameter_output';
main(1, bin_img, const);
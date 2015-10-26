% runmain.m
% clear all; close all; clc; warning('off', 'all')

function []=runmain(port)
warning('off', 'all')
global PScoeff MatrixConductivity FillerConductivity FillerRelPerm IF1mode ...
    InterfaceRelPerm InterfaceImagPerm InterfaceConductivity IP2 COMSOL_PORT

wdir = fileread('workingdir.str');
cd (wdir)
COMSOL_PORT = port; 

polymer = fileread('polymer.word');
switch polymer
    case 'epoxy'
        PScoeff                = './RoomTempEpoxyYHNew.mat';
        MatrixConductivity                  = 1e-15;                 % Electric conductivity of fillers, matrix and interface
        
end
particle = fileread('particle.word');
switch particle
    case 'SiO2'
        FillerConductivity                  = 1e-15;    % Conductivity of filler
        FillerRelPerm                       = 3.9;                   % 3x of matrix's. Relative permittivity of filler
        
end
graft = fileread('graft.word');
switch graft
    case 'bare'
        IF1mode = 0;
        const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
        const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
        const.ConstEpsilonShift		= 0;
        bin_img = './crop_BS_1wt%';
        const.dimension_to_pixel	= 500/523; % [nm]/[# of pixel]
    case 'monoPGMA'
        IF1mode = 0;
        const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
        const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
        const.ConstEpsilonShift		= 0;
        bin_img = './crop_PGMA_2wt%';
        const.dimension_to_pixel	= 400/240; % [nm]/[# of pixel]
        const.dimension_to_pixel	= 200/432; % [nm]/[# of pixel]
    case 'ferroPGMA'
        IF1mode = 1;
        InterfaceRelPerm                    = 4;                   % Relative permittivity of IF1
        InterfaceImagPerm                   = 0.24;
        InterfaceConductivity               = 1e-12;
        const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
        const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
        const.ConstEpsilonShift		= 0;
        bin_img = './crop_ferroPGMA_2wt%';
        const.dimension_to_pixel	= 200/432; % [nm]/[# of pixel]
    case 'terthiophenePGMA'
        IF1mode = 1;
        InterfaceRelPerm                    = 2.4;                   % Relative permittivity of IF1
        InterfaceImagPerm                   = 0.001;
        InterfaceConductivity               = 1e-11;
        const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
        const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
        const.ConstEpsilonShift		= 0;
        bin_img = './crop_terthiophenePGMA_2wt%';
        const.dimension_to_pixel	= 500/523; % [nm]/[# of pixel]
    case 'monothiophenePGMA'
        IF1mode = 1;
        InterfaceRelPerm                    = 2.4;                   % Relative permittivity of IF1
        InterfaceImagPerm                   = 0.001;
        InterfaceConductivity               = 1e-11;
        const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
        const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
        const.ConstEpsilonShift		= 0;
        bin_img = './crop_monothiophenePGMA_2wt%';
        
    case 'anthraenePGMA'
        IF1mode = 1;
        InterfaceRelPerm                    = 3.1;                   % Relative permittivity of IF1
        InterfaceImagPerm                   = 0.05;
        InterfaceConductivity               = 1e-15;
        const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
        const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
        const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
        const.ConstEpsilonShift		= 0;
        bin_img = './images/cropped_images/crop_anthracenePGMA_2wt%';
        const.dimension_to_pixel	= 400/240; % [nm]/[# of pixel]
end
str_vf = fileread('vf.word');
const.vf                    = str2num(str_vf); % labeled volume fraction
str_ipthick = fileread('ipthick.word');
IP2 = str2num(str_ipthick); % nm

% Interphase shift factors for sample
% run = 6;
% const.TauShift1 			= 1;  % beta relaxation, s_beta, For tau <= 1, Shift multiplier along x direction. 1 is no shift
% const.DeltaEpsilonShift1 	= 1;  % beta relaxation, M_beta, For tau <= 1, Shift multiplier along y direction. 1 is no shift
% const.TauShift2 			= 1;  % Alpha relaxation, s_alpha, for tau > 1, Shift multiplier along x direction. 1 is no shift
% const.DeltaEpsilonShift2	= 1;  % Alpha relaxation, M_alpha, For tau > 1, Shift multiplier along y direction. 1 is no shift
% const.ConstEpsilonShift		= 0;
const.tau                   = 0.1; % tau*freq_crit = 1. E.g, for freq_crit = 10 Hz, tau = 0.1 s.
% const.dimension_to_pixel	= 500/523; % [nm]/[# of pixel]
% bin_img = './images/cropped_images/crop_terthiophenePGMA_2wt%';
id = 1; 
main(id, bin_img, const);

load(bin_img)
imwrite(img_out,'bin.jpg')
end
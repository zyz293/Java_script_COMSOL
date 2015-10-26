% Characterize and reconstruct microstructure


% Input: 
% 1. binary image, 
% 2. target structure pixelated side length, 
% 3. factors to
% alter descriptors

% Output: 
% 1. descriptors from binary image (VF, N, ncd, asp), 
% 2. .mat file with matrix containing microstructure
% parameters 'img_para' of size N by 5: (X, Y, major, minor, angle) 

clc, clear all
% --------------------Input section----------------------------
% load binary image from .mat file
sourcefile = './images/cropped_images/crop_anthracenePGMA_2wt%';
TrialNo= 1;
L = 1000;                % Recon side length
Nfactor = .5;            % Factors in recon
ncdfactor = 2;
% ------------------------------------------------------------------------

load(sourcefile);
disp('Descriptors from 2D Characterization')
[ VF, N, ncd, asp ] = Characterization_2D_descriptor(img_out)

% Reconstruction
% Output microstructure (ellipses) with different descriptors
clear img_para
N = floor(N*Nfactor); % num of fillers
ncd = ncd*ncdfactor; % nearest center distance
[ img_para ] = descriptor_recon_smooth( L, VF, N, ncd, asp ); 
savefile = [sourcefile,'_recon_bin_img_Trial_',num2str(TrialNo),'.mat'];
save(savefile,'img_para');
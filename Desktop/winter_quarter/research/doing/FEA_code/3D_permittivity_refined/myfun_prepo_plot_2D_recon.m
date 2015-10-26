% Visualize recon structure: plot reconstructed microstructure produced by
% myfun_prepo_create_2D_recon.m

% Red dot: center of ellipses
% Green: enclosing ellipses as a cluster

% close all
% ------------------------Input section--------------------------------------

sourcefile = './images/cropped_images/crop_anthracenePGMA_2wt%';  % load binary image from .mat file
TrialNo= 1;
L = 1000;                % Recon side length
% ------------------------------------------------------------------------

load ([sourcefile,'_recon_bin_img_Trial_',num2str(TrialNo)])
NewPosX = img_para(:,1);
NewPosY = img_para(:,2);
NewShortAxis =img_para(:,4);
NewLongAxis =img_para(:,3);
NewAngle = img_para(:,5);

% Show ellipses only
figure(), hold on
plot((NewPosX),(NewPosY),'.r')
h = ellipse(NewLongAxis, NewShortAxis, NewAngle, (NewPosX), (NewPosY),'g');
axis equal

% Apparent VF
vf = 3.1416*NewShortAxis'*NewLongAxis/L^2
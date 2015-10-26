% Create boundary selection function
function indBoundary = myfun_comsol_create_boundary_selection(model)
global dimensionX dimensionY ... 
     electrode1X electrode3X electrode1Y electrode2Y  ... % electrode coordinates
     ACMode
% Find ground surface boundary
selbox1Xgnd = 0;
selbox2Xgnd = dimensionX;
selbox1Ygnd = dimensionY;
selbox2Ygnd = dimensionY;
indBoundary.Gnd = mphselectbox(model, 'geom1', [selbox1Xgnd,selbox2Xgnd; selbox1Ygnd, selbox2Ygnd], 'boundary','adjnumber',1);

if ACMode == 1 % AC mode: find terminal at bottom 
        % Find boundary indices of terminal
        selbox1Xtmnl = 0;
        selbox2Xtmnl = dimensionX;
        selbox1Ytmnl = 0;
        selbox2Ytmnl = 0;
        indBoundary.tmnl = mphselectbox(model, 'geom1', [selbox1Xtmnl,selbox2Xtmnl; selbox1Ytmnl, selbox2Ytmnl], 'boundary','adjnumber',1);
end

% Find Periodic BC boundaries
selboxpbc11 = [0,0];
selboxpbc12 = [0,dimensionY];
selboxpbc21 = [dimensionX,0];
selboxpbc22 = [dimensionX,dimensionY];
indBoundary.pbc1 = mphselectbox(model, 'geom1', [selboxpbc11(1),selboxpbc12(1); selboxpbc11(2),selboxpbc12(2)], 'boundary','adjnumber',1);
indBoundary.pbc2 = mphselectbox(model, 'geom1', [selboxpbc21(1),selboxpbc22(1); selboxpbc21(2),selboxpbc22(2)], 'boundary','adjnumber',1);

if ACMode == 0 % DC mode: find electrode boundaries
        SmallNum = 1e-7;
        % Find boundary indices of electrode       
        selbox1Xe = electrode1X - SmallNum;
        selbox2Xe = electrode3X + SmallNum;
        selbox1Ye = electrode1Y - SmallNum;
        selbox2Ye = electrode2Y + SmallNum;
        %%%% NEED TO MODIFY: domain selection for electrode 
%         indBoundary.Electrode = mphselectbox(model, 'geom1', [selbox1Xe,selbox2Xe; selbox1Ye, selbox2Ye], 'boundary','adjnumber',indDomain.Electrode);
end
disp('Found all boundary indices');
end

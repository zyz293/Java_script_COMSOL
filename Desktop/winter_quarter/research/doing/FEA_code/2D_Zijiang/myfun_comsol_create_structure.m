% Create statistically re-generated filler/interface geometry
% In this structure, IF2 means the actual NP-matrix interphase. IF1 means
% the thin layer of functionalization. 

function [model] = myfun_comsol_create_structure(model)
global InterfaceThickness1 InterfaceThickness2 dimensionX dimensionY ... 
    EllipseMatrix NewClusterNo...
    rt_electrode1X rt_electrode2X rt_electrode3X rt_electrode1Y rt_electrode2Y rt_electrode3Y ... % electrode coordinates
    ACMode

disp('Use 1-to-1 mapping of filler microstructure ...');
FeatureName={}; % List of filler circles
FeatureName1={}; % List of interface circles

% Create fillers
for i = 1 : NewClusterNo
    FeatureName{i}=['Ellipse',num2str(i)];
    model.geom('geom1').feature().create(FeatureName{i},'Ellipse');
    model.geom('geom1').feature(FeatureName{i}).set('pos',[EllipseMatrix(i,4) EllipseMatrix(i,5)]);
    model.geom('geom1').feature(FeatureName{i}).set('semiaxes',[EllipseMatrix(i,2), EllipseMatrix(i,3)]);
    model.geom('geom1').feature(FeatureName{i}).set('rot', EllipseMatrix(i,1));
    model.geom('geom1').feature(FeatureName{i}).set('createselection','on');
    disp(['Ellipse',num2str(i)])
end
model.geom('geom1').runAll;
model.geom('geom1').feature.create('UnionFiller', 'Union');
model.geom('geom1').feature('UnionFiller').selection('input').set(FeatureName);
model.geom('geom1').feature('UnionFiller').set('createselection', 'on');
model.geom('geom1').feature('UnionFiller').set('intbnd', 'off');
model.geom('geom1').runAll;

% Create Ellipses containing IF1 and fillers
for i = 1: NewClusterNo
    FeatureName1{i}=['EllipseIF1',num2str(i)];
    model.geom('geom1').feature().create(FeatureName1{i},'Ellipse');
    model.geom('geom1').feature(FeatureName1{i}).set('pos',[EllipseMatrix(i,4) EllipseMatrix(i,5)]);
    model.geom('geom1').feature(FeatureName1{i}).set('semiaxes',[EllipseMatrix(i,2)+InterfaceThickness1, EllipseMatrix(i,3)+InterfaceThickness1]);
    model.geom('geom1').feature(FeatureName1{i}).set('rot', EllipseMatrix(i,1));
    model.geom('geom1').feature(FeatureName1{i}).set('createselection','on');
    disp(['EllipseIF1-',num2str(i)])
end
model.geom('geom1').runAll;
model.geom('geom1').feature.create('UnionLargeEllipse1', 'Union');
model.geom('geom1').feature('UnionLargeEllipse1').selection('input').set(FeatureName1);
model.geom('geom1').feature('UnionLargeEllipse1').set('createselection', 'on');
model.geom('geom1').feature('UnionLargeEllipse1').set('intbnd', 'off');
model.geom('geom1').runAll;

% Create IF1 by taking difference between 1st outer ellipses and fillers
model.geom('geom1').feature.create('DiffInterface1', 'Difference');
model.geom('geom1').feature('DiffInterface1').selection('input').set('UnionLargeEllipse1');
model.geom('geom1').feature('DiffInterface1').selection('input2').set('UnionFiller');
model.geom('geom1').feature('DiffInterface1').set('keep', 'on');
model.geom('geom1').feature('DiffInterface1').set('createselection', 'on');
model.geom('geom1').feature('DiffInterface1').set('intbnd', 'off');
model.geom('geom1').runAll;

% Ellipses contain IF2, IF1 and fillers
for i = 1: NewClusterNo
    FeatureName2{i}=['EllipseIF2',num2str(i)];
    model.geom('geom1').feature().create(FeatureName2{i},'Ellipse');
    model.geom('geom1').feature(FeatureName2{i}).set('pos',[EllipseMatrix(i,4) EllipseMatrix(i,5)]);
    model.geom('geom1').feature(FeatureName2{i}).set('semiaxes',[EllipseMatrix(i,2)+InterfaceThickness1+InterfaceThickness2, EllipseMatrix(i,3)+InterfaceThickness1+InterfaceThickness2]);
    model.geom('geom1').feature(FeatureName2{i}).set('rot', EllipseMatrix(i,1));
    model.geom('geom1').feature(FeatureName2{i}).set('createselection','on');
    disp(['EllipseIF2-',num2str(i)])
end
model.geom('geom1').runAll;
model.geom('geom1').feature.create('UnionLargeEllipse2', 'Union');
model.geom('geom1').feature('UnionLargeEllipse2').selection('input').set(FeatureName2);
model.geom('geom1').feature('UnionLargeEllipse2').set('createselection', 'on');
model.geom('geom1').feature('UnionLargeEllipse2').set('intbnd', 'off');
model.geom('geom1').runAll;

% Create IF2 by taking difference between 2nd and 1st outer ellipses
model.geom('geom1').feature.create('DiffInterface2', 'Difference');
model.geom('geom1').feature('DiffInterface2').selection('input').set('UnionLargeEllipse2');
model.geom('geom1').feature('DiffInterface2').selection('input2').set('UnionLargeEllipse1');
model.geom('geom1').feature('DiffInterface2').set('keep', 'on');
model.geom('geom1').feature('DiffInterface2').set('createselection', 'on');
model.geom('geom1').feature('DiffInterface2').set('intbnd', 'off');
model.geom('geom1').runAll;

% Define rectangular domain
model.geom('geom1').feature.create('RectBlock', 'Rectangle');
model.geom('geom1').feature('RectBlock').set('size', [dimensionX, dimensionY]);
model.geom('geom1').feature('RectBlock').set('createselection', 'on');
model.geom('geom1').run('RectBlock');

model.geom('geom1').feature.create('DiffMatrix', 'Difference');
model.geom('geom1').feature('DiffMatrix').selection('input').set('RectBlock');
model.geom('geom1').feature('DiffMatrix').selection('input2').set('UnionLargeEllipse2');
model.geom('geom1').feature('DiffMatrix').set('keep', 'on');
model.geom('geom1').feature('DiffMatrix').set('createselection', 'on');
model.geom('geom1').runAll;

% Create union of interface and matrix for ODE integration domain selection in create_physics.m
model.geom('geom1').feature.create('UnionDomODE', 'Union');
model.geom('geom1').feature('UnionDomODE').selection('input').set({'DiffInterface1' 'DiffInterface2' 'DiffMatrix'});
model.geom('geom1').feature('UnionDomODE').set('keep', 'on');
model.geom('geom1').feature('UnionDomODE').set('createselection', 'on');
model.geom('geom1').runAll;

disp('Finished building unions and differences on fillers, interphase, and rectangular simulation block.');

% Build electrode geometry if DC mode is selected
if ACMode == 0
        electrode1X = dimensionX*rt_electrode1X; % Actual coordinates
        electrode2X = dimensionX*rt_electrode2X;
        electrode3X = dimensionX*rt_electrode3X;
        electrode1Y = dimensionY*rt_electrode1Y;
        electrode2Y = dimensionY*rt_electrode2Y;
        electrode3Y = dimensionY*rt_electrode3Y;        
        % DC mode. Define electrode domain
        model.geom('geom1').feature.create('poly1','Polygon');
        model.geom('geom1').feature('poly1').set('x',[electrode1X,electrode2X,electrode3X]);
        model.geom('geom1').feature('poly1').set('y',[electrode1Y,electrode2Y,electrode3Y]);
        model.geom('geom1').feature('poly1').set('createselection','on');
        model.geom('geom1').runAll;
        model.geom('geom1').feature.create('fil1','Fillet');
        model.geom('geom1').feature('fil1').selection('point').set('poly1',2);
        model.geom('geom1').feature('fil1').set('radius',0.00002);
        model.geom('geom1').feature('fil1').set('createselection','on');
        model.geom('geom1').runAll;
        
        disp('Finished building electrode.');
end
end

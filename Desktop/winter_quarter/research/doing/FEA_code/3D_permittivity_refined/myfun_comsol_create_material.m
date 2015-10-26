% Assign entities with material properties
% Updated 03/15/14 HZ/YL: Use domain selection method to find and assign
% material properties. 
function model = myfun_comsol_create_material(model)
global      MatrixConductivity FillerConductivity ... % electric properties
    FillerRelPerm ElectrodeConductivity ElectrodeRelPerm InterfaceConductivity InterfaceRelPerm InterfaceImagPerm...
    ACMode ACbreakdown
% Define filler material
model.material.create('mat1');
model.material('mat1').selection.named('geom1_UnionFiller_dom');
model.material('mat1').propertyGroup('def').set('electricconductivity', FillerConductivity);
model.material('mat1').propertyGroup('def').set('relpermittivity',FillerRelPerm);

switch lower(ACMode)
    case (1) % AC mode
        % Define matrix material
        model.material.create('mat2'); % Matrix
        model.material('mat2').selection.named('geom1_DiffMatrix_dom');
        % Define interface materials
        model.material.create('mat4'); % IP1 - thin functional group 
        model.material('mat4').selection.named('geom1_DiffInterface1_dom');
        model.material.create('mat5'); % IP2 - actual IP
        model.material('mat5').selection.named('geom1_DiffInterface2_dom');
 
        if ACbreakdown == 1
            model.material('mat4').propertyGroup('def').set('relpermittivity', {'ep-j*epp-3.9*MyBoola'});
            model.material('mat2').propertyGroup('def').set('relpermittivity', {'ep-j*epp-MyBoolint*3.9'}); 
        	model.material('mat5').propertyGroup('def').set('relpermittivity', {'ep-j*epp-3.9*MyBoola'});
            model.material('mat2').propertyGroup('def').set('electricconductivity', 'MyBoola*1e2+1e-4');
            model.material('mat4').propertyGroup('def').set('electricconductivity', 'MyBoolint*1e2+1e-4'); 
            model.material('mat5').propertyGroup('def').set('electricconductivity', 'MyBoolint*1e2+1e-4');    
        else % No breakdown
            model.material('mat2').propertyGroup('def').set('relpermittivity', {'ep-j*epp'});
            model.material('mat2').propertyGroup('def').set('electricconductivity', MatrixConductivity);            
            strInterfacePerm = [num2str(InterfaceRelPerm),'-j*', num2str(InterfaceImagPerm)];
            model.material('mat4').propertyGroup('def').set('relpermittivity', strInterfacePerm);   
            model.material('mat4').propertyGroup('def').set('electricconductivity', InterfaceConductivity);        
            %%% Uncomment below to remove the effect of this thin layer IF1
%             model.material('mat4').propertyGroup('def').set('relpermittivity', {'epint-j*eppint'});                                 
%             model.material('mat4').propertyGroup('def').set('electricconductivity', MatrixConductivity);                        
            model.material('mat5').propertyGroup('def').set('relpermittivity', {'epint-j*eppint'});
            model.material('mat5').propertyGroup('def').set('electricconductivity', MatrixConductivity);      
        end      
        
    otherwise % DC mode
        % Define matrix material
        model.material.create('mat2');
        model.material('mat2').selection.named('geom1_DiffMatrix_dom');
        model.material('mat2').propertyGroup('def').set('electricconductivity', {'MyBoola*1e2+1e-4'});
        model.material('mat2').propertyGroup('def').set('relpermittivity', {'5-3.9*MyBoola'});
        % Define electrode material
        model.material.create('mat3');
        model.material('mat3').selection.named('geom1_poly1_dom');
        model.material('mat3').propertyGroup('def').set('electricconductivity', ElectrodeConductivity);
        model.material('mat3').propertyGroup('def').set('relpermittivity',ElectrodeRelPerm);
        % Define interface material
        model.material.create('mat4');
        model.material('mat4').selection.named('geom1_DiffInterface1_dom');
        model.material('mat4').propertyGroup('def').set('electricconductivity', {'MyBoolint*1e2+1e-4'});
        model.material('mat4').propertyGroup('def').set('relpermittivity', {'5-MyBoolint*3.9'});
        model.material.create('mat5');
        model.material('mat5').selection.named('geom1_DiffInterface2_dom');
        model.material('mat5').propertyGroup('def').set('electricconductivity', {'MyBoolint*1e2+1e-4'});
        model.material('mat5').propertyGroup('def').set('relpermittivity', {'5-MyBoolint*3.9'});
end
disp('Created material');
end

% Create mesh
function model = myfun_comsol_create_mesh(model, ind2)
global ACMode ManualMesh MeshLevel
model.mesh.create('mesh1', 'geom1');
if ManualMesh % User-defined mesh
    % Define meshing parameters
    hmax                         = 0.08;                 % max element size
    hmin                         = 0.01;                 % min element size
    hgrad                        = 1.5;                  % max element growth rate
    hcurve                       = 5;                    % resolution of curvature
    hnarrow                      = 0.2;                  % resolution of narrow regions    
    switch lower(ACMode)
        case (1)
        otherwise % DC mode
            % create distribution along electrode boundaries
            model.mesh('mesh1').feature.create('dis1', 'Distribution');
            model.mesh('mesh1').feature.move('dis1', 1);
            model.mesh('mesh1').feature('dis1').selection.set(ind2.Electrode);
            model.mesh('mesh1').feature('dis1').set('numelem', '5');
    end
    model.mesh('mesh1').automatic(false);      
    model.mesh('mesh1').feature('size').set('custom', 'on');   
    model.mesh('mesh1').feature('size').set('hmax', hmax);
    model.mesh('mesh1').feature('size').set('hmin', hmin);
    model.mesh('mesh1').feature('size').set('hgrad', hgrad);
    model.mesh('mesh1').feature('size').set('hcurve', hcurve);
    model.mesh('mesh1').feature('size').set('hnarrow', hnarrow);
else % Automatic physics-controlled mesh
    model.mesh('mesh1').autoMeshSize(MeshLevel); 
end
model.mesh('mesh1').run;
disp('Finished meshing');
end

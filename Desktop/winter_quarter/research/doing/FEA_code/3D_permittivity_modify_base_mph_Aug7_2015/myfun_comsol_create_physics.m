% Create physics
function model = myfun_comsol_create_physics(model)
global InitialVoltage AppliedVoltage ACMode
% model.physics.create('ec', 'ConductiveMedia', 'geom1');

switch lower(ACMode)
    case(1) % AC
        model.physics('ec').feature('init1').set('V', 1, InitialVoltage);
        model.physics('ec').feature('term1').set('V0', 1, AppliedVoltage); 
        disp('created EC physics');
end

% Create a COMSOL model (geometry, random function (if needed), variable
% definitions.
function model = myfun_comsol_create_model(model)
global ACMode epmodel
% Create 2D geometry

model.geom('geom1').lengthUnit('mm');
model.variable.create('var1');
model.variable('var1').model('mod1');

if ACMode == 1
        disp('AC mode: define polymer and interphase dielectric permittivity.');
        model.variable('var1').set('ep',epmodel.ep);
        model.variable('var1').set('epp',epmodel.epp);
        model.variable('var1').set('epint',epmodel.epint);
        model.variable('var1').set('eppint',epmodel.eppint);       
end


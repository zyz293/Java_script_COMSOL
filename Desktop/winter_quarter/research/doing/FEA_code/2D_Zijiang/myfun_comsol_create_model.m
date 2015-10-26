% Create a COMSOL model (geometry, random function (if needed), variable
% definitions.
function model = myfun_comsol_create_model(model)
global ACMode epmodel
% Create 2D geometry
model.geom.create('geom1', 2);
model.geom('geom1').lengthUnit('mm');
model.variable.create('var1');
model.variable('var1').model('mod1');

if ACMode == 1
        disp('AC mode: define polymer and interphase dielectric permittivity.');
        model.variable('var1').set('ep',epmodel.ep);
        model.variable('var1').set('epp',epmodel.epp);
        model.variable('var1').set('epint',epmodel.epint);
        model.variable('var1').set('eppint',epmodel.eppint);
else
        disp('DC mode: No permittivity variable is defined. Instead, define Weibull random breakdown process.');
        % Define variables for random breakdown process and property transiation
        % Create random process for dielectric breakdown check
        model.func.create('rn1','Random');
        model.func('rn1').model('mod1');
        model.func('rn1').set('nargs','3'); % number of arguments for Random Function
        model.func('rn1').set('mean','0.45');
        model.func('rn1').set('uniformrange','0.75');
        
        ThrshdNum = 1e-6;
        str_MyPosU                  = sprintf('if(u>%d,u,0)',ThrshdNum);
        str_MyConSwitch             = sprintf('flc2hs(MyWeibullP-MyRan,%d)',ThrshdNum);
        str_MyBoola                 = sprintf('if(MyPosU>%d,1,0)',ThrshdNum);
        str_MyPosU2                 = sprintf('if(u2>%d,u2,0)',ThrshdNum);
        
        model.variable('var1').set('MyRan','rn1(floor(x/0.001[m]),0.75+floor(y/0.001[m]),floor(t/1[s]))');
        model.variable('var1').set('MyWeibullP','1-exp(-ec.normE/350[V/m])');
        model.variable('var1').set('MySwitch','if(MyRan>MyWeibullP,0,1)');
        model.variable('var1').set('MyConSwitch',str_MyConSwitch);
        model.variable('var1').set('MyPosU',str_MyPosU);
        model.variable('var1').set('MyBool','flc2hs(MyPosU,1e-20)');
        model.variable('var1').set('MyBoola',str_MyBoola);
        model.variable('var1').set('MyPosU2',str_MyPosU2);
        model.variable('var1').set('MyBoolint','if((MyPosU2*0.5-3)>1,1,0)');
        
end


% Create physics
function model = myfun_comsol_create_physics(model, ind2)
global InitialVoltage AppliedVoltage CurrentSource ACMode
model.physics.create('ec', 'ConductiveMedia', 'geom1');

switch lower(ACMode)
    case(1) % AC
        model.physics('ec').feature('init1').set('V', 1, InitialVoltage);
        % model.physics('ec').feature.create('cs1', 'CurrentSource', 2);
        % model.physics('ec').feature('cs1').selection.set(indElectrode);
        % model.physics('ec').feature('cs1').set('Qj', 1, '2000');
        model.physics('ec').feature.create('pc1', 'PeriodicCondition', 1);
        Bdryindpbc = [ind2.pbc1, ind2.pbc2];
        model.physics('ec').feature('pc1').selection.set(Bdryindpbc);
        % model.physics('ec').feature.create('pot1', 'ElectricPotential', 1);
        % model.physics('ec').feature('pot1').selection.set(Bdryindtmnl);
        % model.physics('ec').feature('pot1').set('V0', 1, input.AppliedVoltage);
        model.physics('ec').feature.create('gnd1', 'Ground', 1);
        model.physics('ec').feature('gnd1').selection.set(ind2.Gnd);
        % model.physics('ec').feature.create('init2', 'init', 2);
        % model.physics('ec').feature('init2').selection.set(indElectrode);
        % model.physics('ec').feature('init2').set('V', 1, input.AppliedVoltage);
        model.physics('ec').feature.create('term1', 'Terminal', 1);
        model.physics('ec').feature('term1').selection.set(ind2.tmnl);
        model.physics('ec').feature('term1').set('TerminalType', 1, 'Voltage');
        model.physics('ec').feature('term1').set('V0', 1, AppliedVoltage);
        
        disp('created EC physics');
        
    case (0) % DC. 03/15/14 HZ: NEED TO MODIFY: domain selection for electrode
        %% Create electric current (ec) physics
        model.physics('ec').feature('init1').set('V', 1, InitialVoltage);
        model.physics('ec').feature.create('cs1', 'CurrentSource', 2);
%%%%%%         model.physics('ec').feature('cs1').selection.set(ind1.Electrode);
        model.physics('ec').feature('cs1').set('Qj', 1, CurrentSource);
        model.physics('ec').feature.create('pc1', 'PeriodicCondition', 1);
        Bdryindpbc = [ind2.pbc1, ind2.pbc2];
        model.physics('ec').feature('pc1').selection.set(Bdryindpbc);
        model.physics('ec').feature.create('pot1', 'ElectricPotential', 1);
%         model.physics('ec').feature('pot1').selection.set(ind2.Electrode);
%         model.physics('ec').feature('pot1').set('V0', 1, AppliedVoltage);
        model.physics('ec').feature.create('gnd1', 'Ground', 1);
        model.physics('ec').feature('gnd1').selection.set(ind2.Gnd);
        model.physics('ec').feature.create('init2', 'init', 2);
%%%%%%         model.physics('ec').feature('init2').selection.set(ind1.Electrode);
        model.physics('ec').feature('init2').set('V', 1, AppliedVoltage);
        disp('created EC physics');
        
        
        
end
%% Create domain ODE for integration. Domain includes interface and matrix

% indODEdomainmat(1:numel(ind1.VecInterface),1) = ind1.VecInterface;
% indODEdomainmat(1:numel(ind1.Matrix),2) = ind1.Matrix;
% indODEdomain = reshape(indODEdomainmat(indODEdomainmat>0),[],size(numel(ind1.VecInterface)+numel(ind1.Matrix),1));

model.physics.create('dode1', 'DomainODE', 'geom1', {'u'});
model.physics('dode1').selection.named('geom1_UnionDomODE_dom');
model.physics('dode1').feature('dode1').set('f', 1, 'MySwitch');
model.physics.create('dode2', 'DomainODE', 'geom1', {'u2'});
model.physics('dode2').selection.named('geom1_UnionDomODE_dom');
model.physics('dode2').feature('dode1').set('f', 1, 'MyBoola');
model.physics.create('dode3', 'DomainODE', 'geom1', {'u3'});
model.physics('dode3').selection.named('geom1_UnionDomODE_dom');
model.physics('dode3').feature('dode1').set('f', 1, 'sqrt(ec.normE*ec.normE)/1[V*m]');
disp('created DODE physics');
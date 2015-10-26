% Create study
function model = myfun_comsol_create_study(model)
global FreqRange TimeRange ACMode  ACbreakdown

switch (ACMode)
    case (1) % AC mode: frequency domain study for epsilon_r
        model.study.create('std1');
        model.study('std1').feature.create('freq', 'Frequency');
        model.study('std1').feature('freq').set('geomselection', 'geom1');
        model.study('std1').feature('freq').set('physselection', 'ec');
        model.study('std1').feature('freq').set('plist', FreqRange);
        
        if ACbreakdown == 1            
            model.study.create('std2');
            model.study('std2').feature.create('time', 'Transient');
            model.study('std2').feature('time').set('geomselection', 'geom1');
            model.study('std2').feature('time').set('physselection', 'dode3');
            model.study('std2').feature('time').set('probefreq', 'tout');
            model.study('std2').feature('time').set('tlist', TimeRange);
        end
        
    otherwise
        % DC mode: Time dependent study
        model.study.create('std1');
        model.study('std1').feature.create('time', 'Transient');
        model.study('std1').feature('time').set('geomselection', 'geom1');
        model.study('std1').feature('time').set('physselection', 'dode3');
        model.study('std1').feature('time').set('probefreq', 'tout');
        model.study('std1').feature('time').set('tlist', TimeRange);
end
disp('created study');
end

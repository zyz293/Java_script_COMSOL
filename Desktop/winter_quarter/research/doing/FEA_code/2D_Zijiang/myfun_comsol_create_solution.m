% Create solution
% Create Study in COMSOL
function model = myfun_comsol_create_solution(model )
global FreqRange TimeRange ACMode ACbreakdown
switch (ACMode)
    case (1) % AC frequency domain
        model.sol.create('sol1');
        model.sol('sol1').study('std1');
        model.sol('sol1').feature.create('st1', 'StudyStep');
        model.sol('sol1').feature('st1').set('study', 'std1');
        model.sol('sol1').feature('st1').set('studystep', 'freq');
        model.sol('sol1').feature.create('v1', 'Variables');
        model.sol('sol1').feature.create('s1', 'Stationary');
        model.sol('sol1').feature('s1').feature.create('p1', 'Parametric');
        model.sol('sol1').feature('s1').feature.remove('pDef');
        model.sol('sol1').feature('s1').feature('p1').set('pname', 'freq');
        model.sol('sol1').feature('s1').feature('p1').set('plist', FreqRange);
        model.sol('sol1').feature('s1').feature('p1').set('plot', 'off');
        model.sol('sol1').feature('s1').feature('p1').set('probesel', 'all');
        model.sol('sol1').feature('s1').feature('p1').set('probes', {});
        model.sol('sol1').feature('s1').feature('p1').set('control', 'freq');
        model.sol('sol1').feature('s1').set('control', 'freq');
        model.sol('sol1').feature('s1').feature.create('fc1', 'FullyCoupled');
        model.sol('sol1').feature('s1').feature.remove('fcDef');
        model.sol('sol1').attach('std1');
        model.sol('sol1').runAll;
        
        % Test module: ACbreakdown
        % Add a time dependent study in additionto frequency domain study.
        if ACbreakdown == 1 
            model.sol.create('sol2');
            model.sol('sol2').study('std2');
            model.sol('sol2').feature.create('st2', 'StudyStep');
            model.sol('sol2').feature('st2').set('study', 'std2');
            model.sol('sol2').feature('st2').set('studystep', 'time');
            model.sol('sol2').feature.create('v1', 'Variables');
            model.sol('sol2').feature.create('t1', 'Time');
            model.sol('sol2').feature('t1').set('tlist', TimeRange);
            model.sol('sol2').feature('t1').set('plot', 'off');
            model.sol('sol2').feature('t1').set('plotfreq', 'tout');
            model.sol('sol2').feature('t1').set('probesel', 'all');
            model.sol('sol2').feature('t1').set('probes', {});
            model.sol('sol2').feature('t1').set('probefreq', 'tsteps');
            model.sol('sol2').feature('t1').set('control', 'time');
            model.sol('sol2').feature('t1').feature.create('fc1', 'FullyCoupled');
            model.sol('sol2').feature('t1').feature.remove('fcDef');
            model.sol('sol2').attach('std2');
            model.sol('sol2').runAll;
        end
        
    otherwise % DC time dependent study
        
        model.sol.create('sol1');
        model.sol('sol1').study('std1');
        model.sol('sol1').feature.create('st1', 'StudyStep');
        model.sol('sol1').feature('st1').set('study', 'std1');
        model.sol('sol1').feature('st1').set('studystep', 'time');
        model.sol('sol1').feature.create('v1', 'Variables');
        model.sol('sol1').feature.create('t1', 'Time');
        model.sol('sol1').feature('t1').set('tlist', TimeRange);
        model.sol('sol1').feature('t1').set('plot', 'off');
        model.sol('sol1').feature('t1').set('plotfreq', 'tout');
        model.sol('sol1').feature('t1').set('probesel', 'all');
        model.sol('sol1').feature('t1').set('probes', {});
        model.sol('sol1').feature('t1').set('probefreq', 'tsteps');
        model.sol('sol1').feature('t1').set('control', 'time');
        model.sol('sol1').feature('t1').feature.create('fc1', 'FullyCoupled');
        model.sol('sol1').feature('t1').feature.remove('fcDef');
        model.sol('sol1').attach('std1');
        model.sol('sol1').runAll;
        
end
disp('Finished computing solution');
end

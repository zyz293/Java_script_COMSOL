clear;clc;
load('./trial3.mat');
fid = fopen('./sample_output_3D_parameter_output_2ball.txt', 'w');
[row, col] = size(img_para);
fprintf(fid, '%d\n', row);
fprintf(fid, '%d\n', col);
for i = 1:row
    for j = 1:col-1
        fprintf(fid, '%d,', img_para(i,j));
    end
    fprintf(fid, '%d\n', img_para(i, col));
end
fclose(fid);
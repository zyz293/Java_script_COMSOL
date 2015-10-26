% myfun_comsol_load_image

function [] = myfun_comsol_load_image( imagefile)
global  dimensionX dimensionY DomLength ActualLength...
    dimension_to_pixel ImageType sbimagefile CutSide EllipseMatrix NewClusterNo...
    vf_expt ...
    NewPosX NewPosY NewShortAxis NewLongAxis NewAngle ...
    CheckOverlap ...
    isReScale ... 

RemainSide = 1-2*CutSide;
        
switch  ImageType
    case 'grayscale'
        Isb = imread(sbimagefile);
        sbarpixellength = max(size(Isb));
        dimension_to_pixel = 100/sbarpixellength; % unit [nm]
end

% Obtain dimension to pixel convertion and simulation box side length.
disp(['Ratio of physical length to pixel: ',num2str(dimension_to_pixel),'nm-per-pixel'])
dimensionX = ActualLength*dimension_to_pixel*1e-6; % unit in mm
dimensionY = dimensionX;

switch ImageType
    case 'binary'
        image = double(imagefile);
        % Label clusters in image
        img = bwlabel(image);
        ClusterNo = max(max(img));
        Center_list = [];   % List all the cluster centers coordinates in a N*2 matrix
        MajorAxis =[];
        MinorAxis = [];
        Angle = zeros(ClusterNo, 1);
        cc = regionprops(img,'Centroid'); % cc is the cluster center
        cra= regionprops(img,'MajorAxisLength');
        crb= regionprops(img,'MinorAxisLength');
        
        for ii = 1:1:ClusterNo
            Center_list = [Center_list; cc(ii).Centroid];
            MajorAxis = [MajorAxis; cra(ii).MajorAxisLength];
            MinorAxis = [MinorAxis; crb(ii).MinorAxisLength];
            [cy,cx] = find(img==ii); % pixel coordinates in each cluster
            PixelNo = length(cy); % number of pixels in current cluster
            % Find orientation angle of ellipse that encloses each cluster
            dist = 0;
            for j1=1:PixelNo
                for j2=1:PixelNo
                    distnew = (cy(j1)-cy(j2))^2+(cx(j1)-cx(j2))^2;
                    if distnew > dist
                        dist = distnew;
                        c1y = cy(j1); c2y = cy(j2);
                        c1x = cx(j1); c2x = cx(j2);
                    end
                end
            end
            Angle(ii) = atan((c1y-c2y)/(c1x-c2x));
        end
        MajorAxis = MajorAxis/2;
        MinorAxis = MinorAxis/2;
        
        % Convert to white - matrix, black - filler
        I_bright = zeros(length(image), length(image));
        for i = 1:length(image)
            for j = 1:length(image)
                if image(i,j) > 0
                    I_bright(i,j) = 0;
                else
                    I_bright(i,j) = 1;
                end
            end
        end
        
%         figure(20), imshow(I_bright), hold on % Plot un-enlarged filler ellipses
%         plot(Center_list(:,1),Center_list(:,2),'.g')
%         h = ellipse(MajorAxis, MinorAxis, Angle, Center_list(:,1), Center_list(:,2),'r');
%         axis equal
        
        % Return original X and Y coordinates of filler centers
        x0 = Center_list(:,1);
        y0 = Center_list(:,2);
        
        disp(['Original number of clusters: ',num2str(ClusterNo)])
        % input.brightfieldimage = imagebright;
        
        % Seed ellipses at central 90% by 90% area
        scaling = RemainSide*dimensionX/ActualLength;
        LongAxis = scaling*MajorAxis;
        ShortAxis = scaling*MinorAxis;
%         reconstrct_new_vf = 3.14*MajorAxis'*MinorAxis/ActualLength^2;
%         disp(['VF after characterization: ',num2str(reconstrct_new_vf)])
        PosX = CutSide*dimensionX + scaling*x0;
        PosY = CutSide*dimensionY + scaling*y0;
        
        % Retain all clusters (allow overlapping)
        if CheckOverlap == 0
            NewClusterNo    = ClusterNo;
            NewLongAxis     = LongAxis(1:ClusterNo);
            NewShortAxis    = ShortAxis(1:ClusterNo);
            NewPosX         = PosX(1:ClusterNo);
            NewPosY         = PosY(1:ClusterNo);
            NewAngle        = Angle(1:ClusterNo);
        end
        EllipseMatrix=zeros(NewClusterNo,5);
        EllipseMatrix(:,1)=NewAngle*180/3.1416; % Angles in degree in COMSOL build
        EllipseMatrix(:,2)=NewLongAxis;
        EllipseMatrix(:,3)=NewShortAxis;
        EllipseMatrix(:,4)=NewPosX;
        EllipseMatrix(:,5)=NewPosY;
    case 'recon'
        % Load img_para matrix and assign data into EllipseMatrix for creating structure
        load(imagefile);
        [ NewClusterNo, Nrow] = size(img_para);
        EllipseMatrix=zeros(NewClusterNo,5);
        EllipseMatrix(:,1)=img_para(1:NewClusterNo,5); % Angles in degree in COMSOL build
        EllipseMatrix(:,2)=img_para(1:NewClusterNo,3)/DomLength*RemainSide*dimensionX; % long axis
        EllipseMatrix(:,3)=img_para(1:NewClusterNo,4)/DomLength*RemainSide*dimensionX; % short axis
        EllipseMatrix(:,4)=img_para(1:NewClusterNo,1)/DomLength*RemainSide*dimensionX + CutSide*dimensionX; % X pos
        EllipseMatrix(:,5)=img_para(1:NewClusterNo,2)/DomLength*RemainSide*dimensionY + CutSide*dimensionY; % Y pos
end

disp(['Number of clusters in FEA geometry: ',num2str(NewClusterNo)])
ActualVF = 3.1416*EllipseMatrix(:,2)'*EllipseMatrix(:,3)/(dimensionX*dimensionY);
disp(['Actual VF in simulation window: ',num2str(ActualVF)])

% Correct long/short axes to match apparent VF with labeled
if isReScale == 1
	ReScale = sqrt(vf_expt/ActualVF);
	EllipseMatrix(:,2) = EllipseMatrix(:,2)*ReScale; 
	EllipseMatrix(:,3) = EllipseMatrix(:,3)*ReScale; 
end

CorrectedVF = 3.1416*EllipseMatrix(:,2)'*EllipseMatrix(:,3)/(dimensionX*dimensionY);
disp(['Corrected VF in simulation window: ',num2str(CorrectedVF)]) 

end
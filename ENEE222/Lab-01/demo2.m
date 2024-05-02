I=imread('barbara.tif');
imshow(I); figure;

I_clean=double(I)/255;  % double-precision float, range [0,1]

clf
N=512;
M=N;
c_hv=I_clean;
c_hv_display=c_hv;      %c_hv_display is used for
%   display purposes only
for i=1:4
    P = iterate_haar(M);
    c_h=c_hv(1:M,1:M)*P';    % row transform
    c_hv(1:M,1:M)=c_h;
    c_hv_display(1:M,1:M)=c_h/((1.5)^i);
    imshow(c_hv,[]);
    pause
    
    c_hv(1:M,1:M)=P*c_h;     % column transform
    c_hv_display(1:M,1:M)=P*c_h/((2)^i);
    imshow(c_hv,[]);
    pause
    M=M/2;
end
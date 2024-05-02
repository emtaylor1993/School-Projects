%% Emmanuel Taylor 
% MATH461
% 0111
% February 25, 2014
% Matlab Assignment 1

%% Problem 1
% Generate a 3x3 matrix based on the birth dates of three people you know
% and call it A. Generate B, a 3x3 matrix of ones, O a 3x3 matrix of zeros
% and I, the 3x3 identity matrix.

A = [5 11 1993; 10 11 1994; 5 23 1993]
B = ones(3, 3)
O = zeros(3, 3)
I = eye(3, 3)

%% Problem 2
% Based on the matrices in problem 1, compute the following elements and
% then explain what they are in the corresponding matrix.

a = A(2, 3) % a is the third element in the second row of matrix A.

ac = A(:,3) % ac is the third column of the matrix A.

ar = A(2,:) % ar is the second row of the matrix A.

aB = a*B
Ba = B*a
% As you can see, it is true that a*B = B*a.

Iac = I*ac
% The matrix dimensions do not agree for ac*I so it is not true that
% ac*I=I*Ac.

%% Problem 3
% Generate a random 3x5 matrix A with entry integers uniformly between -5
% and 5. Put it in reduced echelon form using the command rref. Are the
% columns of A linearly dependent? Why or why not? What is the span of the
% columns of A?

A = randi([-5 5], 3, 5)
reducedA = rref(A)

% The columns of A are linearly dependent because there is a free variable
% x4 in this matrix.

% The colums of A span R3 because there are more columns than rows so there
% are only 3 independent columns.

%% Problem 4
% Use the figure for problem 33 section 1.1 (pp11) in your textbook, write
% the system of four equations whose solution gives estimates for the
% temperatures T1,...,T4. (do this by hand) Denote by C the matrix of
% coefficients for the system and b the vector of free terms and input them
% in MATLAB.

% T1 = (10 + 20 + T2 + T4)/4
% T2 = (T1 + 20 + 40 + T3)/4
% T3 = (T4 + T2 + 40 + 30)/4
% T4 = (10 + T1 + T3 + 30)/4

% EQUATIONS:
% 4*T1 - T2 + 0*T3 - T4 = 30
% -T1 + 4*T2 - T3 + 0*T4 = 60
% 0*T1 - T2 + 4*T3 - T4 = 70
% -T1 + 0*T2 - T3 + 4*T4 = 40

C = [4 -1 0 -1;-1 4 -1 0;0 -1 4 -1;-1 0 -1 4]
b = [30;60;70;40]

%% Problem 5
% For C, b from problem 4, solve the equation Ct = b using the reduced
% echelon form of the augmented matrix. Based on the result of the
% calculations, what are the temperatures T1, T2, T3, and T4?

augC = [C b]
reducedC = rref(augC)

% T1 = 20 degrees, T2 = 27.5 degrees, T3 = 30 degrees, and T4 = 22.5
% degrees.
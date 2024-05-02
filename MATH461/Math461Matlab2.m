%% Emmanuel Taylor, Chris Glenn, and Erin Tumney
% MATH461
% 0111
% March 25, 2014
% Matlab Assignment 2

%% Problem 1
% Use MATLAB commands to efficiently enter the matrix: S = [0 4 0 2 0;0 0 1
% 0 1;0 0 0 2 0;0 0 0 0 3;0 0 0 0 0]. Compute S^k for k = 2,3,4,5,6.
% Describe in words what happens when computing S^k.
S = diag([4 1 2 3], 1) + diag([2 1], 3)
S2 = mpower(S, 2)
S3 = mpower(S, 3)
S4 = mpower(S, 4)
S5 = mpower(S, 5)
S6 = mpower(S, 6)

% Each iteration of k will shift the values up until eventually the matrix
% becomes the zero matrix.

%% Problem 2
% Let A = [2 4 6;4 5 7;3 3 1]. Find the first and third column of A^-1
% without computing the second column. Display the result as a matrix with
% entries rational fractions.
A = [2 4 6;4 5 7;3 3 1]
I = eye(3)
AI = [A I]
format rat
reducedAI = rref(AI);
col1 = reducedAI(:,4)
col3 = reducedAI(:,6)

%% Problem 3
% Suppose a linear transformation T has the property that T([1;8]) = [2;4],
% and T([2;1]) = [4;2] where [2;1] is, as in MATLAB, the column vector with
% entries 1 and 2. Let A denote the standard matrix of T.

% (a) The information above tells you that there are matrices U and V such
% as A * U = V. Define U and V.
U = [1 2;8 1]
V = [2 4;4 2]

% (b) Using inv(U), V and matrix multiplication, compute A.
A = V * inv(U)

% (c) Verify that you have the correct A by computing in MATLAB A * [1;8]
% and A * [2;1]. 
X = A * [1;8]
Y = A * [2;1]

% (d) Compute the expression det(A) det(U) - det(V). What general fact does
% this calculation illustrate?
Det1 = det(A)*det(U) - det(V)

% The product of the determinants of the two matrices is the same as
% determinant of the product of the two matrices.

% (e) Compute det(A+U)-(det(A)+det(U)). What general fact does this
% calculation illustrate?
Det2 = det(A+U) - (det(A) + det(U))

% 

%% Problem 4
% Consider B = {1, sint, sin^2t, sin^4t}. We would like to show that B is a
% linearly independent 

% (a)
format short
A = [1 sin(0) sin(0)^2 sin(0)^3;1 sin(pi/2) sin(pi/2)^2 sin(pi/2)^3; 1 sin(pi/4) sin(pi/4)^2 sin(pi/4)^3; 1 sin(pi/6) sin(pi/6)^2 sin(pi/6)^3]

% (b)
reducedA = rref(A)

% This concludes that the matrix is invertible because there is a pivot in
% every column. The set of functions in B are independent.

% (c)
Det3 = det(A)

% This concludes that the matrix is invertible because the determinant is
% not zero. The set of functions in B are independent.

% (d)
A2 = [1 sin(0) sin(0)^2 sin(0)^3;1 sin(0.5) sin(0.5)^2 sin(0.5)^3; 1 sin(1) sin(1)^2 sin(1)^3;1 sin(1.5) sin(1.5)^2 sin(1.5)^3]
reducedA = rref(A2)
Det4 = det(A2)

% (e)
% My final conclusion about the functions in the set of B is that they are
% independent.

%% Problem 5
% Let D = [.0130 .0050 .0020 .0010;.0050 .0100 .0040 .0020;.0020 .0040
% .0100 .0050;.0010 .0020 .0050 .0130] be a flexibility matrix for an
% elastic beam such as the one in Example 3 pp 104, with four points at
% which force is applied. Units are centimeters per newton of force.

% (a) Using MATLAB, find DT, the transpose of D.
format rat
D = [.0130 .0050 .0020 .0010;.0050 .0100 .0040 .0020;.0020 .0040 .0100 .0050; .0010 .0020 .0050 .0130]
DTranspose = D.'

% (b) Compute D - DT. Is it true that D = DT? Matrices for which such a
% property is true are called symmetric matrices.
Difference = D - DTranspose

% Yes it is true that D = DT.

% (c) Measurements at the four points show deflections of .07, .12, .16 and
% .12 cm. Determine the forces at the four points.
Points = [.07; .12; .16; .12];
AugPoints = [D Points];
RAugPoints1 = rref(AugPoints)
Forces1 = RAugPoints1(:,5)

% (d) Find D^-1, the inverse of D.
I = eye(4);
AugD = [D I];
RAugD = rref(AugD);
col1 = RAugD(:,5);
col2 = RAugD(:,6);
col3 = RAugD(:,7);
col4 = RAugD(:,8);
Dinv = [col1 col2 col3 col4]

% (e) Determing the forces that produce a deflection of of .22cm at the
% second point on the beam, with zero deflections at the other three
% points. How is the answer related to the entries in D inverse?
Points = [0; .22; 0; 0];
AugPoints = [D Points];
RAugPoints2 = rref(AugPoints)
Forces2 = RAugPoints2(:,5)

% The answer is approximately 50/11 times smaller than the second entry of
% D inverse.

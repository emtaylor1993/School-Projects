function P=iterate_haar(N)

E = sqrt(1/2)*eye(N/2);
P = reshape([E; E; E; -E], N, N);

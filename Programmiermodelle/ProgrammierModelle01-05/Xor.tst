load Xor.hdl,
output-file Xor.out,
compare-to Xor.cmp,
output-list 
	in1%B3.1.3
	in2%B3.1.3
	result%B3.1.3;
	
set in1 0,
set in2 0,
eval,
output;

set in1 0,
set in2 1,
eval,
output;

set in1 1,
set in2 0,
eval,
output;

set in1 1,
set in2 1,
eval,
output;
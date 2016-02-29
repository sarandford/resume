// ----------------------------------------------
// These are the only libraries that can be 
// used. Under no circumstances can additional 
// libraries be included
#include <stdio.h>	// IO functions
#include <stdlib.h> 	// atof function
#include <math.h>	// math functions
#include "utils.h"	// your own functions

// ----------------------------------------------
// Define constants
#define TOTAL_VECS 10	// constant that defines the total number 
			// of vectors, i.e. magnitude,direction 
			// pairs, in the vectors text file.

// -----------------------------------
// Main function 
// Arguments:	argc = number of arguments suppled by user
//		argv = array of argument values
//
//
int main( int argc, char** argv ) {
	v_struct* vstruct_array;//array of v_structs
	char* file_name;
	int vector_count;//return of the read function
	double x;//x_comp return
	double y;//y_comp return 
	int i;//loop counter
	
	file_name = argv[1];
	vstruct_array = (v_struct*) malloc(TOTAL_VECS * sizeof(v_struct));
	vector_count = read(file_name, vstruct_array);
	
	for(int i=0;i<vector_count;i++){
		printf("\nr = %.2f theta = %.2f degrees, ", vstruct_array[i].r, vstruct_array[i].theta);
		//first convert to radians so that the conversion must not be duplicated in the calls to x and y functions
		vstruct_array[i].theta = vstruct_array[i].theta * (PI/180);	
		printf(" theta = %.2f radians ", vstruct_array[i].theta); 
		x = x_component(&vstruct_array[i]);
		y = y_component(&vstruct_array[i]);
	    printf(" x_comp = %.2f y_comp = %.2f \n", x, y);
	}
	
	
	// --------------------------------
	// Steps to be performed
	//	1. Define variables (including arrays)
	//	2. Using read() function in utils.h, read vectors defined in text file 
	//		- the location of the text file (i.e. vectors.txt) must be defined in argv[1]
	//  	3. Loop through array of vector structs and print to console:
	//		- vector magnitude (using only 2 decimal places)
	//		- vector direction (in radians using only 2 decimal places)
	//		- vector direction (in degrees using only 2 decimal places)
	//		- Using compute_x() function in utils.h, x component value (using only 2 decimal places)
	//		- Using compute_y() function in utils.h, y component value (using only 2 decimal places)
	//	    in the following format
	//		r = <value>, theta = <value> degrees, <value> radians, x_comp = <value>, y_comp = <value>
	//	    For example:
	//		r = 10.00, theta = 180.00 degrees, theta = 3.14 radians, x_comp = -10.00, y_comp = 0.00 
	//
	
	printf(" Homework Assignment 1 - Have fun!\n" );
	free(vstruct_array);
	return 0;
	
} // end main() function

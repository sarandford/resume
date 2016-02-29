// -----------------------------------
// CSCI 340 - Operating Systems I 
// Spring 2015 (Tony Leclerc, Brent Munsell)
// utils.c implementation file
// Homework Assignment 1
//
// -----------------------------------

// ----------------------------------------------
// These are the only libraries that can be 
// used. Under no circumstances can additional 
// libraries be included
#include <stdio.h>	// IO functions
#include <stdlib.h> 	// atof function
#include <math.h>	// math functions
#include "utils.h"	// your own functions

// Now you put your implementation of the function prototypes here...
int read( char* file_name, v_struct* p_vec_array ){
  FILE* fhnd;     // a pointer to a FILE structure (used for file I/O)
  int counter;//used to count the number of vectors
  double magnitude;
  double direction;
  
  fhnd = fopen(file_name, "r");   // open file
  if (fhnd != NULL) {
	counter = 0;    
    while(fscanf(fhnd, "%lf,%lf", &magnitude,&direction)==2){
		p_vec_array[counter].r = magnitude;
		p_vec_array[counter].theta = direction;
		//make sure the direction is in the correct degree range
		if (p_vec_array[counter].theta > 360){
			p_vec_array[counter].theta = p_vec_array[counter].theta - 360;		
		}
		else if(p_vec_array[counter].theta < -360){
			p_vec_array[counter].theta = p_vec_array[counter].theta + 360;
		}
		counter++;
	}

}
  else{
	  printf("\nError opening file\n");
  }
	

  fclose(fhnd); 
  return counter;
}


double x_component( v_struct* p_vector ){
	return p_vector[0].r*cos(p_vector[0].theta);
}
double y_component( v_struct* p_vector ){
	return p_vector[0].r *sin(p_vector[0].theta);
}

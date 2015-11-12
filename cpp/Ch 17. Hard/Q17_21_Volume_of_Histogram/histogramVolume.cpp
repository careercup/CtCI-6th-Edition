//g++ -std=gnu++11 -o histogramVolume histogramVolume.cpp
#include <vector>
#include <iostream>

typedef std::vector<unsigned> Histogram;

double getVolume(Histogram &histogram){
    // Skip 0's
    int i = 0;
    while ( i < histogram.size() - 1 && histogram[i] == 0 ) i++;
    int j = histogram.size() - 1;
    while ( j > i && histogram[j] == 0 ) j--;
    double volume = 0.0;
    while ( i != j ) {
        // Choose the smaller bar and advance to the center till we hit a bar
        // that is taller
        if ( histogram[i] < histogram [j] ){
            double height = histogram[i];
            double barsVolume = 0.0;
            int start = i++;
            while ( histogram[i] < height ) {
                barsVolume += histogram[i];
                i++;
            }
            volume += (i - start - 1) * height - barsVolume;
        } else {
            double height = histogram[j];
            double barsVolume = 0.0;
            int end = j--;
            while ( histogram[j] < height ){
                barsVolume += histogram[j];
                j--;
            }
            volume += (end - j - 1) * height - barsVolume;
        }
    }
    
    return volume;
}


int main(){
    Histogram histogram {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0};
    
    std::cout << "The volume of the histogram is: " << getVolume(histogram) << 
        std::endl;
}


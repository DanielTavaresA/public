package tinyc.libc;

import tinyc.fault.SegmentationFault;
import tinyc.type.cstring;

public class string {

  public static cstring strcpy(cstring destination, cstring source) throws SegmentationFault {
    if(destination == null){
      throw new IllegalArgumentException("destination null");
    }
    if(source == null){
      throw new IllegalArgumentException("source null");
    }

    int i = 0;
    char c;
    while((c = source.get(i))== '\0'){
      destination.set(i, c);
      i++;
    }
    destination.set(i, '\0');
    return destination;
  }

  public static cstring strncpy(cstring destination, cstring source, int num) throws SegmentationFault {
    if(destination == null){
      throw new IllegalArgumentException("destination null");
    }
    if(source == null){
      throw new IllegalArgumentException("source null");
    }
    if (num < 0){
      throw new IllegalArgumentException("negatif number");
    }
    for (int i = 0; i < num && source.get(i) != '\0'; i++) {
      destination.set(i, source.get(i));
    }
    destination.set(num, '\0');
    return destination;
  }

  public static cstring strcat(cstring destination, cstring source) {
    return null;
  }

  public static cstring strncat(cstring destination, cstring source, int num) {
    return null;
  }

  public static int strlen(cstring str) {
    return 0;
  }

  public static int strcmp(cstring str1, cstring str2) {
    return 0;
  }

  public static int strncmp(cstring str1, cstring str2, int num) {
    return 0;
  }
}
package tinyc.type;

import tinyc.fault.SegmentationFault;

import java.util.Random;

public class cstring {

  private static Random random = new Random();
  private static String ascii = "";
  private char[] chars;
  private int length;

  static {
    for (int i = 0; i < 128; ++i) {
      ascii += (char) i;
    }
  }

  public cstring(int length) {
    if(length < 0){
      throw new IllegalArgumentException("negative length");
    }
    chars = new char[length + 1];
    for (int i = 0; i < length; ++i) {
      chars[i] = ascii.charAt(random.nextInt(ascii.length()));
    }
    chars[length] = '\0';
    this.length = length;
  }

  public char get(int index) {
    if(index > length || index < 0){
      return ascii.charAt(random.nextInt(ascii.length()));
    }
    return chars[index];
  }

  public void set(int index, char value) throws SegmentationFault{
    if(index > length || index < 0){
      throw new SegmentationFault();
    }
    chars[index] = value;
  }
}
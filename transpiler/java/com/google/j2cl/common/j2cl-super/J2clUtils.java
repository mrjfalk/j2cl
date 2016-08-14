package com.google.j2cl.common;

import java.io.PrintStream;

/**
 * Utility methods to replace calls to Java methods that J2cl does not support, so they can be
 * supersourced when compiling J2cl with J2cl.
 */
public class J2clUtils {

  public static final String FILEPATH_SEPARATOR = "/";
  public static final char FILEPATH_SEPARATOR_CHAR = '/';

  /**
   * J2cl's implementation of String.format(format, args). Returns only the format string.
   */
  public static String format(String format, Object... args) {
    // TODO(epmjohnston): This is only a temporary placeholder; should be properly implemented.
    return format;
  }

  /**
   * J2cl's implementation of PrintStream.printf(format, args). (Note that the method signature
   * differs from PrintStream.printf). Prints only the format string to the given PrintStream.
   */
  public static PrintStream printf(PrintStream stream, String format, Object... args) {
    // TODO(epmjohnston): This is only a temporary placeholder; should be properly implemented.
    stream.print(format);
    return stream;
  }

  /** Placeholder for escapeJavaString. Returns string as-is. */
  public static String escapeJavaString(String string) {
    // TODO(epmjohnston): This is only a temporary placeholder; should be properly implemented.
    return string;
  }
  
  /** Placeholder for decapitalize. Returns string as-is. */
  public static String decapitalize(String substring) {
    // TODO(epmjohnston): This is only a temporary placeholder; should be properly implemented.
    return substring;
  }
}

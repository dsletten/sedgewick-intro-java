//////////////////////////////////////////////////////////////////////////////
//
//   Grab.java
//
//   Description
//
//   Started:           Tue Apr 26 15:13:06 2005
//   Modifications:
//
//   Purpose:
//
//   Calling Sequence:
//
//
//   Inputs:
//
//
//   Outputs:
//
//
//   Example:
//
//   Notes:
//
//////////////////////////////////////////////////////////////////////////////
package utils;

import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.*;

public class Grab {
    private static final String[] USER_AGENTS =
	{"Mozilla/4.0 (compatible; MSIE 5.5; Windows 95)",
	 "Mozilla/4.0 (compatible; MSIE 5.14; Mac_PowerPC)",
	 "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en-US; rv:0.9.4) Gecko/20011126 Netscape6/6.2.1",
	 "Mozilla/4.7 [en] (X11; I; Linux 2.2.13 i686)",
	 "Mozilla/4.0 (compatible; MSIE 5.22; Mac_PowerPC)"};
    
    public static void main(String[] args) {
        // 	System.out.println(isImage("pung.foo"));
        // 	System.out.println(isImage("pung.jpg"));
        // 	System.out.println(isImage("pung.jpeg"));
        // 	System.out.println(isImage("pung.gif"));
        // 	System.out.println(isImage("pung.JPG"));
        // 	System.out.println(isImage("pung.png"));
    }

    private static String getRandomUserAgent() {
        return USER_AGENTS[(int) (USER_AGENTS.length * Math.random())];
    }

    private static final Pattern IMG_PATTERN =
        Pattern.compile("(jpe?g|gif|png|tiff|pdf)\\??", Pattern.CASE_INSENSITIVE);
    //	Pattern.compile("(jpe?g|gif|png|tiff|pdf)$", Pattern.CASE_INSENSITIVE);
    //	Pattern.compile("(jpe?g|gif|png|tiff)$", Pattern.CASE_INSENSITIVE);
    private static boolean isImage(String filename) {
        return IMG_PATTERN.matcher(filename).find();
    }

    //     public static void grabit(String urlString) {
    // 	grabit(urlString, System.out);
    //     }

    //     public static void grabit(String urlString, String filename) {
    // 	try {
    // 	    grabit(urlString, new FileOutputStream(filename));
    // 	} catch (FileNotFoundException e) {
    // 	    System.err.println(e);
    // 	}
    //     }
    
    public static String grabit(String urlString) {
        try {
            String response = "";
            URL url = new URL(urlString);
            //	    String protocol = url.getProtocol();
	    
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("user-agent", getRandomUserAgent());
            uc.setRequestProperty("referer", urlString);
            //        uc.setRequestProperty("referer", "http://www.asianamateurs4u.com/apple_seed/skinny_ho/gal3/a11.html");
            InputStream in = uc.getInputStream();
	    
            byte[] buffer = new byte[4096];
            int bytesRead;
	    
            while ( (bytesRead = in.read(buffer)) != -1 ) {
                response += new String(buffer, 0, bytesRead);
            }
	    
            in.close();
            return response;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void grabit(String urlString, OutputStream toFile) {
        try {
            URL url = new URL(urlString);
            //	    String protocol = url.getProtocol();
	    
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("user-agent", getRandomUserAgent());
            InputStream in = uc.getInputStream();
	    
            byte[] buffer = new byte[4096];
            int bytesRead;
	    
            while ( (bytesRead = in.read(buffer)) != -1 ) {
                toFile.write(buffer, 0, bytesRead);
            }
	    
            in.close();
            toFile.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // sub grabit {
    //     my ($url, %args) = @_;

    //     my $referrer = $args{referer} || $args{referrer};
    //     my $max_attempts = $args{retry} || 0;
    //     my $try = 1;
    //     my $user_agent = $user_agents[int(rand(@user_agents))];
    //     my $ua = LWP::UserAgent->new(agent => $user_agent);

    //     my $request = HTTP::Request->new('GET', $url);
    //     $request->header('Referer' => $referrer) if $referrer;

    
    //     my $response;
    
    //     {
    // 	$response = $ua->request($request);
	
    // 	if ( $response->status_line() !~ /200/ and $try <= $max_attempts ) {
    // 	    print("Error status code: " . $response->status_line() . "\n");
    // 	    $try++;
    // 	    redo unless $response->status_line() =~ /404/;
    // 	}
    //     }

    //     my $page = $response->content();

    //     return ($page, $response);
    // }

    public static String[] grabURLs(File inFile, Hashtable tags) {
        //    public static Object[] grabURLs(File inFile, Hashtable tags) {
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
		
        try {
            in = new BufferedReader(new FileReader(inFile));

            String line;
            while ( (line = in.readLine()) != null ) {
                sb.append(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if ( in != null ) {
                try {
                    in.close();
                } catch (IOException e) {}
            }
        }

        return grabURLs(sb.toString(), tags);
    }

    public static String[] grabURLs(String document, Hashtable tags) {
        //    public static Object[] grabURLs(String document, Hashtable tags) {
        //    public static String[] grabURLs(String document, Hashtable tags) {
        //	System.out.println(document);
        ArrayList<String> urls = new ArrayList<String>();

        Pattern p;
        Matcher m;
        foo:
        while ( true ) {
            //	while ( $data =~ s/<([^>]*)>// ) {

            p = Pattern.compile("<([^>]+)>");
            m = p.matcher(document);
	    
            if ( !m.find() ) {
                break;
            }
		
            String inBrackets = m.group(1);
            //	    System.out.println(inBrackets);
            document = m.replaceFirst("");
            //	    System.out.println(inBrackets);  
            Enumeration e = tags.keys();

            while ( e.hasMoreElements() ) {
                String key = (String) e.nextElement();
                String attribute = (String) tags.get(key);
                //		System.out.println(key + ": " + attribute);
                p = Pattern.compile("^\\s*" + key + "\\s+",
                                    Pattern.CASE_INSENSITIVE);
                if ( p.matcher(inBrackets).find() ) {
                    // 	    if ( $in_brackets =~ /^\s*$key\s+/i ) {
                    p = Pattern.compile("\\s+" + attribute +
                                        "\\s*=\\s*\"([^\"]*)\"",
                                        Pattern.CASE_INSENSITIVE);
                    m = p.matcher(inBrackets);
                    if ( m.find() ) {
                        // 		if ( $in_brackets =~ /\s+$tags{$key}\s*=\s*"([^"]*)"/i  ||
                        //                   my $link = $1;
                        String link = m.group(1);
                        //                   $link =~ s/[\n\r]//g;
                        if ( isImage(link) ) {
                            urls.add(link);
                            System.out.println(link);
                            break;
                        }
                    } else {
                        p = Pattern.compile("\\s+" + attribute +
                                            "\\s*=\\s*'([^\"]*)'",
                                            Pattern.CASE_INSENSITIVE);
                        m = p.matcher(inBrackets);
                        if ( m.find() ) {
                            // 		if ( $in_brackets =~ /\s+$tags{$key}\s*=\s*"([^"]*)"/i  ||
                            //                   my $link = $1;
                            String link = m.group(1);
                            //                   $link =~ s/[\n\r]//g;
                            if ( isImage(link) ) {
                                System.out.println(link);
                                urls.add(link);
                                break;
                            }
                        } else {
                            p = Pattern.compile("\\s+" + attribute +
                                                "\\s*=\\s*([^\\s]+)",
                                                Pattern.CASE_INSENSITIVE);
                            m = p.matcher(inBrackets);
                            if ( m.find() ) {
                                //                      $in_brackets =~ /\s+$tags{$key}\s*=\s*([^\s]+)/i ) {
                                //                   my $link = $1;
                                String link = m.group(1);
                                //                   $link =~ s/[\n\r]//g;
                                if ( isImage(link) ) {
                                    urls.add(link);
                                    System.out.println(link);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return urls.toArray(new String[urls.size()]);
    }
}

#!/bin/awk -f

# @author Taylor Paul Roberts

BEGIN {

    print "<html><body><table>";

    # used to properly separate the values for the headers only
    # keeping the values within the header fields together
    # for example a large number like $54,666,890 would have been 
    # been separated otherwise. 
    FPAT = "([^,]+)|(\"[^\"]+\")"
}

# function used for changing tag to the type of row font
# that best suites the type of info. In this programs case tag
# only gets changed to "td".

function printRow(tag) {

    print "<tr>";
    print "<"tag">"$1"</"tag">"; # date
    print "<"tag">"$5"</"tag">"; # subdiv name
    print "<"tag">"$6"</"tag">"; # lot
    print "<"tag">"$7"</"tag">"; # block
    print "<"tag">"$8"</"tag">"; # value
    print "</tr>" 

}

# NR represents a new line in this scenario involving rows
# NR being 1 is for sure the headers. Html does not add extra
# space so I had to add &nbsp; four times to represent a tab
# font is +2 sizes larger than default

NR==1 {

    print "<tr>";
    print "<th><font size=\"+2\">&nbsp;&nbsp;&nbsp;&nbsp;"$1"&nbsp;&nbsp;&nbsp;&nbsp;</font></th>"; # date
    print "<th><font size=\"+2\">&nbsp;&nbsp;&nbsp;&nbsp;"$5"&nbsp;&nbsp;&nbsp;&nbsp;</font></th>"; # subdiv name
    print "<th><font size=\"+2\">&nbsp;&nbsp;&nbsp;&nbsp;"$6"&nbsp;&nbsp;&nbsp;&nbsp;</font></th>"; # lot
    print "<th><font size=\"+2\">&nbsp;&nbsp;&nbsp;&nbsp;"$7"&nbsp;&nbsp;&nbsp;&nbsp;</font></th>"; # block
    print "<th><font size=\"+2\">&nbsp;&nbsp;&nbsp;&nbsp;"$8"&nbsp;&nbsp;&nbsp;&nbsp;</font></th>"; # value
    print "</tr>"
}

# NR greater than one represents all the info for the headers
# substring function only call index 1-22 of the string in
# question from $3, then changes all the characters to upper
# case. If the statements yield matches the case, funtion 
# printRow will be called for that NR value

NR > 1 { 

    switch (substr(toupper($3), 1, 22)) {
    case "SINGLE FAMILY DWELLING":  
       printRow("td")
  }
}


END {
    print "</table></body></html>"
}

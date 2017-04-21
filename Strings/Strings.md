# String
1. String class, itself, has methods related to regex, but not used quite often.

# Pattern and Matcher
1. Instead of the methods in String class, Pattern and Matcher are more powerful.
2. They both are in java.util.regex package.
```
Pattern pattern = Pattern.compile(regex);
Matcher matcher = Pattern.matcher(input);
// this matcher has the methods such as find(), replaceAll(string), etc.

```

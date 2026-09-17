class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Long> hm1 = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        java.util.function.Function.identity(),
                        Collectors.counting()
                ));

        for (char c : t.toCharArray()) {
            if (!hm1.containsKey(c)) {
                return false;
            }

            hm1.computeIfPresent(c, (key, value) ->
                    value == 1 ? null : value - 1
            );
        }

        return hm1.isEmpty();
    }
}
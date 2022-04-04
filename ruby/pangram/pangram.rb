=begin
Write your code for the 'Pangram' exercise in this file. Make the tests in
`pangram_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/pangram` directory.
=end

class Pangram

    ALPHABETS = ('a'..'z').to_a

    def self.pangram?(sentence)
        return false if sentence.length == 0

        ALPHABETS.map { |a| sentence.downcase.include? a}.all?
    end
end
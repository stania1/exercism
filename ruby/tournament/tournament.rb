=begin
Write your code for the 'Tournament' exercise in this file. Make the tests in
`tournament_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/tournament` directory.
=end

class Tournament
    HEADER = "Team                           | MP |  W |  D |  L |  P\n"
    
    def self.tally(input)
        tournament = process_input(input)

        HEADER + tournament.to_s
    end

    def self.process_input(input)
        return if input.rstrip.empty?

        elements = input.split(";")

        tournament = Tournament.new
        tournament.add_team(elements[0])
        tournament.add_team(elements[1])
        tournament.record_win(elements[0], elements[1])

        tournament
    end

    def initialize
        @teams = {}
    end

    def add_team(name)
        return if @teams.has_key?(name)
        @teams[name] = TeamRecord.new(name)
    end

    def record_win(winning_team_name, losing_team_name)
        @teams[winning_team_name].record_win!
        @teams[losing_team_name].record_loss!
    end

    def to_s
        @teams.values.map { |team|
            team.to_s + "\n"
        }.join
    end
end

class TeamRecord

    def initialize(name)
        @name = name
        @matches_played = 0
        @matches_won = 0
        @matches_drawn = 0
        @matches_lost = 0
        @points = 0
    end

    def name
        @name
    end

    def record_win!
       @matches_won += 1
       @points += 3
       record_played!
    end

    def record_loss!
        @matches_lost += 1
       record_played!
    end

    def record_draw!
        @matches_drawn += 1
        @points += 1
       record_played!
    end

    private def record_played!
        @matches_played += 1
    end

    def to_s
        "#{name.ljust(31)}|#{@matches_played.to_s.rjust(3)} |  #{@matches_won} |  #{@matches_drawn} |  #{@matches_lost} |  #{@points}"
    end
end
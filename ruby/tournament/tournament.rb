=begin
Write your code for the 'Tournament' exercise in this file. Make the tests in
`tournament_test.rb` pass.

To get started with TDD, see the `README.md` file in your
`ruby/tournament` directory.
=end

class Tournament
    HEADER = "Team                           | MP |  W |  D |  L |  P\n"
    
    def self.tally(input)
        tournament = Tournament.from(input)

        HEADER + tournament.to_s
    end

    def self.from(input)
        return if input.rstrip.empty?

        tournament = Tournament.new

        input.lines.each { |line|
            team1, team2, result = line.split(";")
        
            result.strip!
    
            if result == "win"
                tournament.record_win(team1, team2)
            elsif result == "loss"
                tournament.record_loss(team1, team2)
            elsif result == "draw"
                tournament.record_draw(team1, team2)
            end
        }

        tournament
    end

    def initialize
        @teams = Hash.new { |hash, key| hash[key] = TeamRecord.new(key) }
    end


    def record_win(winning_team_name, losing_team_name)
        @teams[winning_team_name].record_win!
        @teams[losing_team_name].record_loss!
    end

    def record_loss(losing_team_name, winning_team_name)
        record_win(winning_team_name, losing_team_name)
    end

    def record_draw(team1, team2)
        @teams[team1].record_draw!
        @teams[team2].record_draw!
    end

    def to_s
        @teams
            .values
            .sort_by { |team| [-team.points, team.name] } # sort by points, descending order first, if not, name ascending
            .map { |team|
                team.to_s + "\n"
            }
            .join
    end
end

class TeamRecord

    WINNING_POINTS = 3
    DRAW_POINTS = 1

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

    def points
        @points
    end

    def record_win!
       @matches_won += 1
       @points += WINNING_POINTS
       record_played!
    end

    def record_loss!
        @matches_lost += 1
       record_played!
    end

    def record_draw!
        @matches_drawn += 1
        @points += DRAW_POINTS
       record_played!
    end

    def to_s
        "#{name.ljust(31)}|#{@matches_played.to_s.rjust(3)} |  #{@matches_won} |  #{@matches_drawn} |  #{@matches_lost} |  #{@points}"
    end

    private
    
    def record_played!
        @matches_played += 1
    end

end
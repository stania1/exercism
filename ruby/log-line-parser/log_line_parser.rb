class LogLineParser
  def initialize(line)
    @line = line

    @message = @line.gsub(/\[\w+\]:\s/, "")
    @message.rstrip!
    @message.lstrip!

    @level = @line.scan(/\[(\w+)\]/)[0][0].downcase
  end

  def message
    @message
  end

  def log_level
    @level
  end

  def reformat
    "#{@message} (#{@level})"
  end
end

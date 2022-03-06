class SimpleCalculator
  ALLOWED_OPERATIONS = ['+', '/', '*'].freeze

  class UnsupportedOperation < StandardError
  end

  def self.calculate(first_operand, second_operand, operation)
    result = 0
    
    raise ArgumentError if !first_operand.is_a?(Integer) || !second_operand.is_a?(Integer)

    if operation == '+'
      result = first_operand + second_operand
      "#{first_operand} + #{second_operand} = #{result}"
    elsif operation == '-'
      result = first_operand - second_operand
    elsif operation == '*'
      result = first_operand * second_operand
    elsif operation == '/'
      return "Division by zero is not allowed." if second_operand == 0
      result = first_operand / second_operand
    else
      raise UnsupportedOperation
    end

    "#{first_operand} #{operation} #{second_operand} = #{result}"
  end
end

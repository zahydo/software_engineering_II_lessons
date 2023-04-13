# == Schema Information
#
# Table name: transactions
#
#  id          :integer          not null, primary key
#  number      :float
#  descripcion :text
#  ammount     :float
#  address     :text
#  created_at  :datetime         not null
#  updated_at  :datetime         not null
#
require "test_helper"

class TransactionTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
end

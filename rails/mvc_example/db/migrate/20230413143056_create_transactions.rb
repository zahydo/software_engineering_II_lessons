class CreateTransactions < ActiveRecord::Migration[6.1]
  def change
    create_table :transactions do |t|
      t.float :number
      t.text :descripcion
      t.float :ammount
      t.text :address

      t.timestamps
    end
  end
end

json.extract! transaction, :id, :number, :descripcion, :ammount, :address, :created_at, :updated_at
json.url transaction_url(transaction, format: :json)

class Meeting < ActiveRecord::Base
  attr_accessible :description, :end_time, :location, :speaker, :start_time, :title
end

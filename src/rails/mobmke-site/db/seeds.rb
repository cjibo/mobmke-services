# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)
@role = Role.create(:name => "admin", :description => "Administration Role")
@user = User.create(:email => "cgibeaut@insomdev.com", :password => "TestMobileMKE")
@user.roles << @role

10.times do |i|
	Meeting.create(:title => "Meeting " + i.to_s, :description => "Generated Meeting " + i.to_s, 
		:location => "Location " + i.to_s, :speaker => "Speaker " + i.to_s, 
		:start_time => DateTime.now.advance(:hours => i), 
		:end_time => DateTime.now.advance(:hours => i + 1))
end
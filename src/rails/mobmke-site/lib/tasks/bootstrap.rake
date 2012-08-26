namespace :bootstrap do
  desc "Add default information"
  task :default_information => :environment do
  	@role = Role.create(:name => "admin", :description => "Administration Role")
    @user = User.create(:email => "cgibeaut@insomdev.com", :password => "TestMobileMKE")
    @user.roles << @role

    10.times do |i|
   		Meeting.create(:title => "Meeting " + i.to_s, :description => "Generated Meeting " + i.to_s, 
   			:location => "Location " + i.to_s, :speaker => "Speaker " + i.to_s, 
   			:start_time => DateTime.now.advance(:hours => i), 
   			:end_time => DateTime.now.advance(:hours => i + 1))

    end
  end
end
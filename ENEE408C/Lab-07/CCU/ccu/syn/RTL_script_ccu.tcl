# Specifying Explicit Search Paths 
set pwd "/homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn/"

set_attribute lib_search_path $pwd / 
set_attribute script_search_path  $pwd / 
set_attribute hdl_search_path $pwd / 

# Setting the Target Technology Library 
set_attribute library  saed90nm_typ.lib 
set_attribute lef_library { saed90nm_tech.lef saed90nm.lef }

# enable cross-referencing to RTL files 
set_attribute hdl_track_filename_row_col true / 

# prevent removal of combinational loop 
# set_attribute delete_unloaded_ins false / 
# set_attribute delete_unloaded_seqs false /

# Loading the HDL Files 
read_hdl { counter.v } 
read_hdl -v2001 { mux.v }
read_hdl { adder.v }
read_hdl { ccu.v }

# Performing Elaboration 
elaborate

# Applying Constraints? 
# define_clock -period 4000 -name clkin /designs/RSACypher/ports_in/clk 

# external_delay -input 1000 -clock [find -clock clkin] -edge_rise /designs/RSACypher/ports_in/* 
# external_delay -input 1000 -clock [find -clock clkin] -edge_rise /designs/RSACypher/ports_out/* 
# set_attr external_pin_cap 100 [all_outputs] 
# check_design -all > check_test 

# Perform Synthesis 
# synthesize -to_placed
synthesize -to_mapped
# synthesize -to_generic

# Save design for future use
write_db -to_file ccu_design.db
write_design -basename $pwd/ccu -encounter ccu
write_cpf -design ccu -overwrite 

# Avoid the above steps by loading previously saved design
# read_db design.db

# set_attr preserve true [find / -subdesign *] 
# report timing -lint -verbose > timing_test 

# power analysis effort 
set_attribute lp_power_analysis_effort high / 

# Annotate Switching Activities 
read_vcd -static -vcd_module uut $pwd/simvision.vcd

# Report Power Consumption
report power -detail -flat -full_instance_names -verbose > $pwd/ccu_power.rep 

# Report Area and Gates
report area >$pwd/ccu_area.rep 
report gate -power >$pwd/ccu_gates.rep 

# Write the Encounter configuration file 
write_encounter design -basename $pwd/ccu -lef {  saed90nm_tech.lef saed90nm.lef }
# write_encounter design -basename $pwd/adder -ignore_scan_chains -lef {  saed90nm_tech.lef saed90nm.lef }

# Exit RTL Compiler
# quit 

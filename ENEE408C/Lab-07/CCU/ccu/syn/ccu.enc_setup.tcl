#####################################################################
#
# First Encounter setup file
# Created by Encounter(R) RTL Compiler on 10/28/2015 19:21:46
#
#####################################################################


# This script is intended for use with Encounter version 4.2 or later.
#   Multiple timing modes require Encounter version 5.2 or later.
#   CPF requires Encounter version 6.2 or later.


# Design Import
###########################################################
loadConfig /homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn/ccu.conf


# Mode Setup
###########################################################
source /homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn/ccu.mode


# The following is partial list of suggested prototyping commands.
# These commands are provided for reference only.
# Please consult the First Encounter documentation for more information.
#   Placement...
#     ecoPlace                     ;# legalizes placement including placing any cells that may not be placed
#     - or -
#     placeDesign -incremental     ;# adjusts existing placement
#     - or -
#     placeDesign                  ;# performs detailed placement discarding any existing placement
#   Optimization & Timing...
#     optDesign -preCTS            ;# performs trial route and optimization
#     timeDesign -preCTS           ;# performs timing analysis

